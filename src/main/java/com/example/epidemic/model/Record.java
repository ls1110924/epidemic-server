package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {

    @JsonProperty("id")
    private int id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("user_mobile")
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
