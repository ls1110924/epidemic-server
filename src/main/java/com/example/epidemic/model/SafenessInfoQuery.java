package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SafenessInfoQuery {

    @JsonProperty("name")
    private String name;

    @JsonProperty("idNum")
    private String idNum;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("area")
    private List<String> area;

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

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
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
