package com.thienday.posmanagement.constant;

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
}
