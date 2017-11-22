package com.ailianlian.base.utils;

/**
 * @author miaoxiongfei@foxmail.com
 * @date 2016-04-08 12:06
 */
public class ClickUtil {


    private static long lastClickTime;

    private static long intervalTime = 400L;// 默认间隔时间


    /**
     * 判断点击过快
     *
     * @return true 点击过快，false 正常点击
     */
    public static boolean isFastClick() {
        return isFastClick(intervalTime);
    }

    /**
     * 点击过快判断
     *
     * @param intervalTime 间隔时间，毫秒
     *
     * @return true 点击过快，false 正常点击
     */
    public static boolean isFastClick(long intervalTime) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < intervalTime) {    // 2次间隔事件小于规定值,认为点击过快
            return true;
        }
        lastClickTime = time;// 记录上次点击时间
        return false;
    }


}
