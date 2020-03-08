package com.example.epidemic.utils;

public class Constants {

    // 特殊值，最高一级的区域Id
    public static final String NATION_AREA_ID = "0";

    // 最大的健康体温
    public static final float MAX_SAFENESS_TEMPER = 37.2f;

    // 分别为体温的上下限
    public static final float MIN_TEMPER = 35f;
    public static final float MAX_TEMPER = 42f;

    // 缓存最大有效时长，即1分钟
    public static final long MAX_CACHE_VALID = 60 * 1000;

}
