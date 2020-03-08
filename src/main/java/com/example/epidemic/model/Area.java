package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Area {

    @JsonProperty("id")
    private int id;

    @JsonProperty("areaId")
    public String areaId;

    @JsonProperty("areaName")
    public String areaName;

    @JsonProperty("areaType")
    public int areaType;

    @JsonProperty("parentAreaId")
    public String parentAreaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

    public String getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(String parentAreaId) {
        this.parentAreaId = parentAreaId;
    }
}
