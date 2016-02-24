package com.elite.freesocks.utils;

/**
 * Created by wjc133.
 * Date: 2016/2/25
 * Time: 0:30
 * Description:
 */
public class StringUtils {
    public static String getContent(String rawData) {
        if (rawData == null) {
            return null;
        }
        return rawData.split(":")[1];
    }
}
