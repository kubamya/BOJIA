package com.example.util;

import java.util.UUID;

/**
 * 公用方法
 */
public class CommonUtil {

    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
