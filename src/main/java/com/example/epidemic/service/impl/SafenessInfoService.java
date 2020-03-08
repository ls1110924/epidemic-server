package com.example.epidemic.service.impl;

import com.example.epidemic.dao.ISafenessInfoDao;
import com.example.epidemic.enumeration.ResultType;
import com.example.epidemic.exception.BizException;
import com.example.epidemic.model.SafenessInfo;
import com.example.epidemic.model.SafenessInfoQuery;
import com.example.epidemic.service.ISafenessInfoService;
import com.example.epidemic.utils.CollectionUtils;
import com.example.epidemic.utils.Constants;
import com.example.epidemic.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("safenessInfoService")
public class SafenessInfoService implements ISafenessInfoService {

    @Autowired
    private ISafenessInfoDao safenessInfoDao;

    public void insert(SafenessInfoQuery infoQuery) {
        if (StringUtils.isEmpty(infoQuery.getName())) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "姓名不得为空");
        }
        if (StringUtils.isEmpty(infoQuery.getIdNum())) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "身份证号不得为空");
        }
        if (StringUtils.isEmpty(infoQuery.getPhone())) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "手机号不得为空");
        }
        if (CollectionUtils.isEmpty(infoQuery.getArea()) || infoQuery.getArea().size() != 3) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "请选择合法的区县");
        }
        float temper;
        try {
            temper = Float.parseFloat(infoQuery.getTemperature());
            if (Float.compare(temper, Constants.MIN_TEMPER) < 0 || Float.compare(temper, Constants.MAX_TEMPER) > 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "体温信息错误");
        }
        List<String> area = infoQuery.getArea();


        SafenessInfo info = new SafenessInfo();
        info.setName(infoQuery.getName());
        info.setIdNum(infoQuery.getIdNum());
        info.setPhone(infoQuery.getPhone());
        info.setProvinceAreaId(area.get(0));
        info.setCityAreaId(area.get(1));
        info.setCountyAreaId(area.get(2));
        info.setTemperature(temper);
        info.setCreatedAt(System.currentTimeMillis());

        safenessInfoDao.insert(info);
    }

    public List<SafenessInfo> findAll() {
        return safenessInfoDao.findAll();
    }

    public List<SafenessInfo> findAllByPrefixAreaId(String areaId) {
        if (StringUtils.isEmpty(areaId)) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "模糊查询区域Id不得为空");
        }
        return safenessInfoDao.findAllByPrefixAreaId(areaId);
    }

    public List<SafenessInfo> findAllByCountyAreaId(String countyAreaId) {
        if (StringUtils.isEmpty(countyAreaId)) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "查询区域Id不得为空");
        }
        return safenessInfoDao.findAllByCountyAreaId(countyAreaId);
    }
}
