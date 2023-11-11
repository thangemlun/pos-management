package com.thienday.posmanagement.constant;

import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static String CAN_NOT_BE_NULL(String field){
        return String.format("%s can not be null !",field);
    }

    public static String NOT_FOUND(String field){
        return String.format("%s can not be found !",field);
    }

    public static String EXIST_IMEI(String field){
        return String.format("%s : imei existed !",field);
    }

    public static Set<String> ADMIN_ROLES() {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");
        return roles;
    }
}
