package com.example.epidemic.service;

import com.example.epidemic.model.Report;

public interface IReportService {

    /**
     * 生成指定区域的报表数据
     *
     * @param areaId 区域Id
     * @return 报表数据
     */
    Report generateReport(String areaId);

}
