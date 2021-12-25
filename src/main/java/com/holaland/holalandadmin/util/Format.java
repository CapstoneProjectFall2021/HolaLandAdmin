package com.holaland.holalandadmin.util;

import com.holaland.holalandadmin.entity.Role;

import java.util.List;

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

    public static String roleCovert(List<Role> roles) {
        String userRole="";
        for (Role role : roles) {
            userRole += (role.getRoleId() == 1 ? "Thành viên" : (role.getRoleId() == 2 ? "Nhà tuyển dụng"
                    : (role.getRoleId() == 3 ? "Bán hàng" : "Học sinh")))
                    + ((roles.indexOf(role) == (roles.size()-1)) ? "" : ", ");
        }
        return userRole;
    }
}
