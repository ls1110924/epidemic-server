package com.example.epidemic.controller;

import com.example.epidemic.model.PageResult;
import com.example.epidemic.model.Record;
import com.example.epidemic.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("prototype")
@RequestMapping("records")
public class RecordController {

    @Autowired
    private IRecordService recordService;

    /**
     * 分页获取记录数据
     * @return
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public PageResult<Record> index(@RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        return recordService.findByPage(page, size);
    }
}
