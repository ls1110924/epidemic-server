package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SafenessInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("idNum")
    private String idNum;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("area")
    private String area;

    @JsonProperty("temperature")
    private String temperature;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "SafenessInfo{" +
                "name='" + name + '\'' +
                ", idNum='" + idNum + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
