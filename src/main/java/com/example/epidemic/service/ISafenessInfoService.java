package com.example.epidemic.service;

import com.example.epidemic.model.SafenessInfo;
import com.example.epidemic.model.SafenessInfoQuery;

import java.util.List;

public interface ISafenessInfoService {

    /**
     * 新增一条健康信息记录
     *
     * @param info 健康信息
     */
    void insert(SafenessInfoQuery info);

    /**
     * 查询所有的健康信息记录
     *
     * @return 健康信息记录列表
     */
    List<SafenessInfo> findAll();

    /**
     * 查询指定区域前缀的健康信息记录
     *
     * @param areaId 区域Id
     * @return 健康信息记录列表
     */
    List<SafenessInfo> findAllByPrefixAreaId(String areaId);

    /**
     * 查询指定县域的健康信息记录
     *
     * @param countyAreaId 县Id
     * @return 健康信息记录列表
     */
    List<SafenessInfo> findAllByCountyAreaId(String countyAreaId);

}
