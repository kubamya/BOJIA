package com.example.util;

import java.util.HashMap;
import java.util.Map;



public class CommonReturnUtil {

    public static Map<String, Object> CommonReturnMsg(int code,Object data, String msg){
        //定义返回map
        Map<String, Object> resultMap = new HashMap<>();

        //返回的提示信息
        resultMap.put("code", code);

        //返回的提示信息
        resultMap.put("msg", msg);

        //返回的数据
        resultMap.put("data", data);
        return resultMap;
    }

}
