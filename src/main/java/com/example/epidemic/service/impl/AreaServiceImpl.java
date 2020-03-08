package com.example.epidemic.service.impl;

import com.example.epidemic.dao.IAreaDao;
import com.example.epidemic.model.Area;
import com.example.epidemic.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaDao areaDao;

    public Area findByAreaId(String areaId) {
        Area area = areaDao.findByAreaId(areaId);
        if (area == null) {
            throw new IllegalArgumentException("请输入合法的地区Id");
        }
        return area;
    }

    public List<Area> findChildAreaByParentAreaId(String parentAreaId) {
        List<Area> areas = areaDao.findChildAreaByParentAreaId(parentAreaId);
        if (areas == null) {
            throw new IllegalArgumentException("请输入合法的地区Id");
        }
        return areas;
    }
}
