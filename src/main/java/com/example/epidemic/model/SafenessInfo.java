package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SafenessInfo {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("idNum")
    private String idNum;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("provinceAreaId")
    private String provinceAreaId;

    @JsonProperty("cityAreaId")
    private String cityAreaId;

    @JsonProperty("countyAreaId")
    private String countyAreaId;

    @JsonProperty("temperature")
    private float temperature;

    @JsonProperty("createdAt")
    private long createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvinceAreaId() {
        return provinceAreaId;
    }

    public void setProvinceAreaId(String provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }

    public String getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(String cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getCountyAreaId() {
        return countyAreaId;
    }

    public void setCountyAreaId(String countyAreaId) {
        this.countyAreaId = countyAreaId;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SafenessInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNum='" + idNum + '\'' +
                ", phone='" + phone + '\'' +
                ", provinceAreaId='" + provinceAreaId + '\'' +
                ", cityAreaId='" + cityAreaId + '\'' +
                ", countyAreaId='" + countyAreaId + '\'' +
                ", temperature=" + temperature +
                ", createdAt=" + createdAt +
                '}';
    }
}
