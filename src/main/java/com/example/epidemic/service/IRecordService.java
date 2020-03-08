package com.example.epidemic.service;

import com.example.epidemic.model.PageResult;
import com.example.epidemic.model.Record;

public interface IRecordService {

    /**
     * 分页查询所有的商家
     * @param page
     * @param size
     * @return
     */
    PageResult<Record> findByPage(int page, int size);
}
