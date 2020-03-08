package com.example.epidemic.controller;

import com.example.epidemic.enumeration.ResultType;
import com.example.epidemic.exception.BizException;
import com.example.epidemic.model.*;
import com.example.epidemic.service.IReportService;
import com.example.epidemic.service.ISafenessInfoService;
import io.github.forezp.distributedlimitcore.annotation.Limit;
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
     * 使用limit注解进行限流，即1S最多调用30次
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "submit")
    @Limit(key = "submitEpidemicSafeness", limtNum = 30, seconds = 1)
    public Response<Boolean> submit(@RequestBody SafenessInfoQuery info) {
        Response<Boolean> result = new Response<Boolean>();
        try {
            safenessInfoService.insert(info);

            result.setCode(0);
            result.setMessage("成功");
            result.setData(true);
        } catch (Exception e) {
            result.setCode(parseErrorCode(e));
            result.setMessage(e.getMessage());
            result.setData(false);
        }
        return result;
    }

    /**
     * 查询指定区域的报表数据
     * 使用limit注解进行限流，即1S最多调用30次
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "query")
    @Limit(key = "queryEpidemicReport", limtNum = 30, seconds = 1)
    public Response<Report> query(@RequestBody ReportQuery query) {
        Response<Report> result = new Response<Report>();
        try {
            Report report = reportService.generateReport(query.getArea());

            result.setCode(0);
            result.setMessage("成功");
            result.setData(report);
        } catch (Exception e) {
            result.setCode(parseErrorCode(e));
            result.setMessage(e.getMessage());
        }
        return result;
    }

    private static int parseErrorCode(Exception e) {
        if (e instanceof BizException) {
            return ((BizException) e).getCode();
        }
        return ResultType.OTHER.type;
    }

}
