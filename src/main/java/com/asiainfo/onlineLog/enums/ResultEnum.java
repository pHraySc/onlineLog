package com.asiainfo.onlineLog.enums;

/**
 * 返回结果枚举.
 * Created by RUOK on 2017/6/15.
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(-1, "未知错误");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
