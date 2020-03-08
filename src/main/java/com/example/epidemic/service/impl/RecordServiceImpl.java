package com.example.epidemic.service.impl;

import com.example.epidemic.dao.IRecordDao;
import com.example.epidemic.model.PageResult;
import com.example.epidemic.model.Record;
import com.example.epidemic.service.IRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordService")
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private IRecordDao recordDao;

    public PageResult<Record> findByPage(int page, int size) {
        PageHelper.startPage(page, size);

        PageInfo<Record> pageInfo = new PageInfo<Record>(recordDao.findAll());

        PageResult.Meta meta = new PageResult.Meta();
        meta.setCurrentPage(pageInfo.getPageNum());
        meta.setPerPage(pageInfo.getPageSize());
        meta.setTotalCount(pageInfo.getTotal());
        meta.setPageCount(pageInfo.getPages());

        PageResult<Record> pageResult = new PageResult<Record>();
        pageResult.setList(pageInfo.getList());
        pageResult.setMeta(meta);

        return pageResult;
    }
}
