package com.example.epidemic.enumeration;

public enum ResultType {

    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 非法参数
     */
    ILLEGAL_PARAMETER(1),

    /**
     * 其他
     */
    OTHER(99);

    public final int type;

    ResultType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static ResultType valueOf(int type) {
        for (ResultType resultType : values()) {
            if (resultType.type == type) {
                return resultType;
            }
        }
        throw new IllegalArgumentException("type类型非法");
    }

}
