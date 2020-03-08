package com.example.epidemic.service.impl;

import com.example.epidemic.dao.IAreaDao;
import com.example.epidemic.enumeration.ResultType;
import com.example.epidemic.exception.BizException;
import com.example.epidemic.model.Area;
import com.example.epidemic.service.IAreaService;
import com.example.epidemic.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaDao areaDao;

    public Area findByAreaId(String areaId) {
        if (StringUtils.isEmpty(areaId)) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "区域Id不得为空");
        }
        Area area = areaDao.findByAreaId(areaId);
        if (area == null) {
            throw new IllegalArgumentException("请输入合法的地区Id");
        }
        return area;
    }

    public List<Area> findChildAreaByParentAreaId(String parentAreaId) {
        if (StringUtils.isEmpty(parentAreaId)) {
            throw new BizException(ResultType.ILLEGAL_PARAMETER.type, "上级区域Id不得为空");
        }
        List<Area> areas = areaDao.findChildAreaByParentAreaId(parentAreaId);
        if (areas == null) {
            throw new IllegalArgumentException("请输入合法的地区Id");
        }
        return areas;
    }
}
