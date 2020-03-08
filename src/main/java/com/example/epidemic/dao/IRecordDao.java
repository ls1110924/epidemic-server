package com.example.epidemic.dao;

import com.example.epidemic.model.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecordDao {

    /**
     * 查询指定id的记录
     * @param id
     * @return
     */
    Record findById(long id);

    /**
     * 查询所有记录
     * @return
     */
    List<Record> findAll();
}
