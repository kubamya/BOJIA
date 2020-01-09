package com.example.consts;

/**
 * 十六进制常量
 */
public class HexConsts {

    /**
     * 操作类型-读取
     */
    public static final int OPT_TYPE_READ = 0x03;

    /**
     * 操作类型-操作
     */
    public static final int OPT_TYPE_WRITE = 0x06;

    /**
     * 停在中间
     */
    public static final int DEV_STATU_TZZJ = 0x00;

    /**
     * 正转运行
     */
    public static final int DEV_STATU_ZZYX = 0x01;

    /**
     * 正转停止
     */
    public static final int DEV_STATU_ZZTZ = 0x02;

    /**
     * 反转运行
     */
    public static final int DEV_STATU_FZYX = 0x03;

    /**
     * 反转停止
     */
    public static final int DEV_STATU_FZTZ = 0x04;

    /**
     * 水泵运行
     */
    public static final int SB_STATU_ON = 0x01;

    /**
     *水泵停止
     */
    public static final int SB_STATU_OFF = 0x00;

    /**
     * 电磁阀-全部关闭
     */
    public static final int DCF_STATU_ALLOFF = 0x00;

    /**
     * 电磁阀-1号开启
     */
    public static final int DCF_STATU_01ON = 0x01;

    /**
     * 电磁阀-2号开启
     */
    public static final int DCF_STATU_02ON = 0x02;

    /**
     * 电磁阀-3号开启
     */
    public static final int DCF_STATU_03ON = 0x03;

    /**
     * 电磁阀-4号开启
     */
    public static final int DCF_STATU_04ON = 0x04;

    /**
     * 肥料-开启
     */
    public static final int FL_STATU_ON = 0x01;

    /**
     * 肥料-关闭
     */
    public static final int FL_STATU_OFF = 0x00;

    /**
     * 肥料-缺水
     */
    public static final int FL_STATU_QS = 0x03;

    /**
     * 补光灯-开启
     */
    public static final int BGD_STATU_ON = 0x01;

    /**
     * 补光灯-关闭
     */
    public static final int BGD_STATU_OFF = 0x00;

    /**
     * 运行模式-自动
     */
    public static final int RUN_MODE_AUTO = 0x01;

    /**
     * 运行模式-手动
     */
    public static final int RUN_MODE_MENU = 0x00;

    /**
     * 远程开关-开启
     */
    public static final int CTR_STATU_ON = 0x01;

    /**
     * 远程开关-关闭
     */
    public static final int CTR_STATU_OFF = 0x00;

}
