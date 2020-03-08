package com.example.epidemic.service;

import com.example.epidemic.model.Area;

import java.util.List;

/**
 * 区域表数据操作服务
 */
public interface IAreaService {

    /**
     * 查找指定areaId的记录
     *
     * @param areaId 地区Id
     * @return 地区记录
     */
    Area findByAreaId(String areaId);

    /**
     * 查找指定areaId的下级记录
     *
     * @param parentAreaId 上级地区Id
     * @return 下级地区记录列表
     */
    List<Area> findChildAreaByParentAreaId(String parentAreaId);

}
