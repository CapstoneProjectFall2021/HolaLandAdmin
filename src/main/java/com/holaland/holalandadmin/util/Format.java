package com.holaland.holalandadmin.util;

public class Format {

    public static String orderId(int id) {
        String strId = "" + id;
        int length = 6 - strId.length();

        while (length > 0) {
            strId = "0" + strId;
            --length;
        }
        return strId;
    }

    public static String title(String title, int length) {
        String shortTitle;
        if(title.length() <= length) {
            shortTitle = title;
        }else {
            shortTitle = title.substring(0,length) + "...";
        }
        return shortTitle;
    }
}
