package com.example.epidemic.service.impl;

import com.example.epidemic.enumeration.AreaType;
import com.example.epidemic.enumeration.ResultType;
import com.example.epidemic.exception.BizException;
import com.example.epidemic.model.Area;
import com.example.epidemic.model.Report;
import com.example.epidemic.model.SafenessInfo;
import com.example.epidemic.service.IAreaService;
import com.example.epidemic.service.IReportService;
import com.example.epidemic.service.ISafenessInfoService;
import com.example.epidemic.utils.CollectionUtils;
import com.example.epidemic.utils.Constants;
import com.example.epidemic.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service("reportService")
public class ReportServiceImpl implements IReportService {

    @Autowired
    private IAreaService areaService;
    @Autowired
    private ISafenessInfoService safenessInfoService;

    private final Report emptyReport;

    // 内存缓存，将查询数据缓存一分钟，以提高并发性能
    private final Map<String, ReportCacheModel> reportCacheMap = new ConcurrentHashMap<String, ReportCacheModel>();

    private static class ReportCacheModel {
        // 缓存数据
        private Report report;
        // 最大缓存时间
        private long maxValidMs;
    }

    public ReportServiceImpl() {
        emptyReport = new Report();
        emptyReport.setxAxis(Collections.<String>emptyList());
        emptyReport.setNormal(Collections.<Integer>emptyList());
        emptyReport.setAbnormal(Collections.<Integer>emptyList());
    }

    public Report generateReport(String areaId) {
        if (StringUtils.isEmpty(areaId)) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "查询区域Id不得为空");
        }

        Report reportCache = getReportCache(areaId);
        if (reportCache != null) {
            // 命中缓存
            return reportCache;
        }

        // 是否是最顶层的国家节点
        final boolean isNationArea = Constants.NATION_AREA_ID.equals(areaId);
        // 是否是最底层的县域节点
        boolean isCountyArea = false;

        // 当前选中的节点层级
        Area selectedArea = null;
        AreaType selectedAreaType = AreaType.NATION;
        if (!isNationArea) {
            selectedArea = areaService.findByAreaId(areaId);
            selectedAreaType = AreaType.valueOf(selectedArea.getAreaType());
            isCountyArea = selectedAreaType == AreaType.COUNTY;
        }
        // 待统计纬度是选中节点的下一层
        AreaType targetAreaType = AreaType.valueOf(Math.min(selectedAreaType.type + 1, AreaType.COUNTY.type));

        // 查询areaId的子节点，构造横纵数据
        List<Area> areas;
        if (isCountyArea) {
            areas = Collections.singletonList(selectedArea);
        } else {
            areas = areaService.findChildAreaByParentAreaId(areaId);
        }
        if (CollectionUtils.isEmpty(areas)) {
            return emptyReport;
        }

        List<SafenessInfo> infos;
        if (isNationArea) {
            infos = safenessInfoService.findAll();
        } else if (isCountyArea) {
            infos = safenessInfoService.findAllByCountyAreaId(areaId);
        } else {
            infos = safenessInfoService.findAllByPrefixAreaId(areaId);
        }

        if (CollectionUtils.isEmpty(infos)) {
            return emptyReport;
        }

        Map<String, Area> areaMap = convertArea(areas);
        Map<String, NormalNum> normalNumMap = countNormal(infos, targetAreaType);

        List<String> areaNameList = new ArrayList<String>();
        List<Integer> normalList = new ArrayList<Integer>();
        List<Integer> abnormalList = new ArrayList<Integer>();

        for (String tmpAreaId : areaMap.keySet()) {
            NormalNum normalNum = normalNumMap.get(tmpAreaId);
            areaNameList.add(areaMap.get(tmpAreaId).getAreaName());
            normalList.add(normalNum == null ? 0 : normalNum.normal);
            abnormalList.add(normalNum == null ? 0 : normalNum.abnormal);
        }

        Report reportResult = new Report();
        reportResult.setxAxis(areaNameList);
        reportResult.setNormal(normalList);
        reportResult.setAbnormal(abnormalList);

        // 存储作为缓存
        putReportCache(areaId, reportResult);

        return reportResult;
    }

    private Map<String, Area> convertArea(List<Area> areas) {
        Map<String, Area> areaMap = new HashMap<String, Area>();
        for (Area area : areas) {
            areaMap.put(area.getAreaId(), area);
        }
        return areaMap;
    }

    private Map<String, NormalNum> countNormal(List<SafenessInfo> infos, AreaType areaType) {
        Map<String, NormalNum> normalNumMap = new HashMap<String, NormalNum>();

        for (SafenessInfo info : infos) {
            String areaId = getProperAreaId(info, areaType);
            NormalNum normalNum = normalNumMap.get(areaId);
            if (normalNum == null) {
                normalNum = new NormalNum();
                normalNumMap.put(areaId, normalNum);
            }
            if (Float.compare(info.getTemperature(), Constants.MAX_SAFENESS_TEMPER) > 0) {
                normalNum.abnormal++;
            } else {
                normalNum.normal++;
            }
        }

        return normalNumMap;
    }

    private String getProperAreaId(SafenessInfo info, AreaType targetAreaType) {
        switch (targetAreaType) {
            case PROVINCE:
                return info.getProvinceAreaId();
            case CITY:
                return info.getCityAreaId();
            case COUNTY:
                return info.getCountyAreaId();
            default:
                throw new IllegalStateException("illegal areaType");
        }
    }

    private Report getReportCache(String areaId) {
        ReportCacheModel reportCacheModel = reportCacheMap.get(areaId);
        if (reportCacheModel != null && reportCacheModel.maxValidMs >= System.currentTimeMillis()) {
            // 缓存不为空且在有效期内，则返回
            return reportCacheModel.report;
        }
        return null;
    }

    private void putReportCache(String areaId, Report report) {
        ReportCacheModel reportCacheModel = new ReportCacheModel();
        reportCacheModel.report = report;
        reportCacheModel.maxValidMs = System.currentTimeMillis() + Constants.MAX_CACHE_VALID;
        reportCacheMap.put(areaId, reportCacheModel);
    }

    private static class NormalNum {
        private int normal;
        private int abnormal;
    }

}
