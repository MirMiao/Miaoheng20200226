package com.bw.miaoheng20200226.entity;

/**
 * 时间 :2020/2/26  16:39
 * 作者 :苗恒
 * 功能 :
 */
public class RegisterEntity {


    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
