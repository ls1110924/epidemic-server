package com.example.epidemic.utils;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String wrapNullString(String str) {
        return wrapNullString(str, "");
    }

    public static String wrapNullString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static String wrapEmptyString(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    public static String trimString(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.trim();
    }

}
