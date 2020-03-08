package com.example.epidemic.controller;

import com.example.epidemic.model.*;
import com.example.epidemic.service.IAreaService;
import com.example.epidemic.service.ISafenessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("epidemic")
public class EpidemicController {

    @Autowired
    private IAreaService areaService;

    @Autowired
    private ISafenessInfoService safenessInfoService;

    /**
     * 测试
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "test")
    public Response<List<Area>> test() {
        List<Area> area = areaService.findChildAreaByParentAreaId("31");

        Response<List<Area>> result = new Response<List<Area>>();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(area);
        return result;
    }

    /**
     * 提交健康上报数据
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "submit")
    public Response<Boolean> submit(@RequestBody SafenessInfoQuery info) {
        // TODO
        System.out.println("################--->" + info.toString());

        Response<Boolean> result = new Response<Boolean>();
        try {
            safenessInfoService.insert(info);

            result.setCode(0);
            result.setMessage("成功");
            result.setData(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMessage(e.getMessage());
            result.setData(false);
        }

        return result;
    }

    /**
     * 提交健康上报数据
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "query")
    public Response<Report> query(@RequestBody ReportQuery query) {
        // TODOs
        System.out.println("################--->" + query.toString());

        Report report = new Report();
        report.setxAxis(Arrays.asList("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        report.setNormal(Arrays.asList(120, 132, 101, 134, 90, 230, 210));
        report.setAbnormal(Arrays.asList(220, 182, 191, 234, 290, 330, 310));

        Response<Report> result = new Response<Report>();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(report);
        return result;
    }

}
