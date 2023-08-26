package com.trangroup.posmanagement.posEnum;

public enum ResponseStatusEnum {
    SUCCESS("success"),
    FAILED("Fail")
    ;
    private String status;
    ResponseStatusEnum(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
