package com.example.enums;

public enum HttpStatusEnum {
    SUCCESS(1,"成功"),
    FAIL(2,"失败"),
    PARAM_ERROR(3,"参数错误"),
    UPLOAD_FAIL(4,"上传失败");
    private Integer code;
    private String message;
    HttpStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
