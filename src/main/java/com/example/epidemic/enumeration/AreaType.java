package com.example.epidemic.enumeration;

public enum AreaType {

    // 国家
    NATION(0),
    // 省
    PROVINCE(1),
    // 市
    CITY(2),
    // 县
    COUNTY(3);

    public final int type;

    AreaType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static AreaType valueOf(int type) {
        for (AreaType areaType : values()) {
            if (areaType.type == type) {
                return areaType;
            }
        }
        throw new IllegalArgumentException("type类型非法");
    }

}
