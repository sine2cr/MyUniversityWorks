package com.javaSElearn;

public class qqChaeck {
    public static boolean checkQQ(String qq) {
        if (qq == null || qq.length() < 6 || qq.length() > 20) {
            return false;
        }
        for (int i = 0; i < qq.length(); i++) {
            char ch = qq.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    //正则表达式
    public static boolean checkQQ2(String qq) {
        return qq.matches("\\d{6,20}");
    }
}
