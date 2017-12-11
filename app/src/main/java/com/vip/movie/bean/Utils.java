package com.vip.movie.bean;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class Utils {
    public static double mapValueFromRangeToRange(double value, double fromLow, double fromHigh, double toLow, double toHigh) {
        return toLow + ((value - fromLow) / (fromHigh - fromLow) * (toHigh - toLow));
    }

    // 中间值, value<low, 返回low, value>high, 返回high.
    public static double clamp(double value, double low, double high) {
        return Math.min(Math.max(value, low), high);
    }
}
