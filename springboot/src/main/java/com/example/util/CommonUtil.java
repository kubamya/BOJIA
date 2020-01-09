package com.example.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 公用方法
 */
public class CommonUtil {

    /**
     * 十六进制字符串分割(有空格)
     * @param str
     * @return
     */
    public static String[] getHexStrBlank(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        String[] strList = str.split(" ");

        return strList;
    }

    /**
     * 十六进制字符串分割(无空格)
     * @param str
     * @return
     */
    public static List<String> getHexStrNoBlank(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        String[] strList = str.split("");
        List<String> resultList = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < strList.length; i++){
            temp = temp + strList[i];
            if((i+1) % 2 == 0) {
                resultList.add(temp);
                temp = "";
            }
        }
        return resultList;
    }

    /**
     * 生成CRC16校验码
     * @param data
     * @return
     */
    public static String getCRC(String data) {
        data = data.replace(" ", "");
        int len = data.length();
        if (!(len % 2 == 0)) {
            return "0000";
        }
        int num = len / 2;
        byte[] para = new byte[num];
        for (int i = 0; i < num; i++) {
            int value = Integer.valueOf(data.substring(i * 2, 2 * (i + 1)), 16);
            para[i] = (byte) value;
        }
        return getCRC(para);
    }

    public static String getCRC(byte[] bytes) {
        //CRC寄存器全为1
        int CRC = 0x0000ffff;
        //多项式校验值
        int POLYNOMIAL = 0x0000a001;
        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        //结果转换为16进制
        String result = Integer.toHexString(CRC).toUpperCase();
        if (result.length() != 4) {
            StringBuffer sb = new StringBuffer("0000");
            result = sb.replace(4 - result.length(), 4, result).toString();
        }
        //交换高低位
        return result.substring(2, 4) + result.substring(0, 2);
    }

    /**
     * 生成随机用户名
     * @return
     */
    public static String getRandomUserName(){
        StringBuffer sb = new StringBuffer("用户_");
        String userName = sb.append(CommonUtil.getUUid()).toString();
        userName = userName.substring(0,8);
        return userName;
    }

    /**
     * 生成32位uuid
     * @return
     */
    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 日期转字符串
     * @param date
     * @return
     */
    public static String dateToStr(Date date){
        if(date == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     * @param str
     * @return
     */
    public static Date strToDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前日期
     * @return
     */
    public static Date getCurDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date getCurDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
