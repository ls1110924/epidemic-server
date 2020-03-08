package com.example.epidemic.service.impl;

import com.example.epidemic.dao.ISafenessInfoDao;
import com.example.epidemic.model.SafenessInfo;
import com.example.epidemic.model.SafenessInfoQuery;
import com.example.epidemic.service.ISafenessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("safenessInfoService")
public class SafenessInfoService implements ISafenessInfoService {

    @Autowired
    private ISafenessInfoDao safenessInfoDao;

    public void insert(SafenessInfoQuery infoQuery) {
        float temper = 0;
        try {
            temper = Float.parseFloat(infoQuery.getTemperature());
        } catch (Exception e) {
            throw new IllegalArgumentException("体温信息错误");
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
        return safenessInfoDao.findAllByPrefixAreaId(areaId);
    }
}
