package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportQuery {

    @JsonProperty("area")
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ReportQuery{" +
                "area='" + area + '\'' +
                '}';
    }
}
