package com.example.epidemic.dao;

import com.example.epidemic.model.SafenessInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISafenessInfoDao {

    /**
     * 新增一条健康上报信息记录
     *
     * @param info 健康信息
     */
    void insert(SafenessInfo info);

    /**
     * 查询出所有的健康信息记录
     *
     * @return 记录列表
     */
    List<SafenessInfo> findAll();

    /**
     * 查询出以areaId为前缀的所有信息记录
     *
     * @param areaId 区域Id
     * @return 记录列表
     */
    List<SafenessInfo> findAllByPrefixAreaId(String areaId);

}
