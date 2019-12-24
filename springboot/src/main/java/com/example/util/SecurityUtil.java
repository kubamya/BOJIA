package com.example.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码加密工具类
 */
public class SecurityUtil {

    public static String MD5Encode(String prototype) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String resultStr = "";
        byte[] resultByteArray = md.digest(prototype.getBytes("utf-8"));
        for (byte b : resultByteArray) {
        	String tempStr = Integer.toHexString(b & 0xff);
            if(tempStr.length() == 1)
            {
            	tempStr = "0" + tempStr;
            }
            resultStr = resultStr + tempStr;
		}
        return resultStr;
    }
}
