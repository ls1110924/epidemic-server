package com.example.epidemic.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 调试工具类
 */
public class DebugUtils {

    public static void log(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(obj));
        } catch (Exception e) {
            // do nothing
        }
    }

}
