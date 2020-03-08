package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Report {

    @JsonProperty("xAxis")
    private List<String> xAxis;

    @JsonProperty("normal")
    private List<Integer> normal;

    @JsonProperty("abnormal")
    private List<Integer> abnormal;

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public List<Integer> getNormal() {
        return normal;
    }

    public void setNormal(List<Integer> normal) {
        this.normal = normal;
    }

    public List<Integer> getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(List<Integer> abnormal) {
        this.abnormal = abnormal;
    }
}
