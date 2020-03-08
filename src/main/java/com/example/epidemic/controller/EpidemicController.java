package com.example.epidemic.controller;

import com.example.epidemic.model.*;
import com.example.epidemic.service.IReportService;
import com.example.epidemic.service.ISafenessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("prototype")
@RequestMapping("epidemic")
public class EpidemicController {

    @Autowired
    private ISafenessInfoService safenessInfoService;
    @Autowired
    private IReportService reportService;

    /**
     * 提交健康上报数据
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "submit")
    public Response<Boolean> submit(@RequestBody SafenessInfoQuery info) {
        Response<Boolean> result = new Response<Boolean>();
        try {
            safenessInfoService.insert(info);

            result.setCode(0);
            result.setMessage("成功");
            result.setData(true);
        } catch (Exception e) {
            result.setCode(1);
            result.setMessage(e.getMessage());
            result.setData(false);
        }
        return result;
    }

    /**
     * 查询指定区域的报表数据
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "query")
    public Response<Report> query(@RequestBody ReportQuery query) {
        Response<Report> result = new Response<Report>();
        try {
            Report report = reportService.generateReport(query.getArea());

            result.setCode(0);
            result.setMessage("成功");
            result.setData(report);
        } catch (Exception e) {
            result.setCode(1);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
