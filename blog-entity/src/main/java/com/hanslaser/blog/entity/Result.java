package com.hanslaser.blog.entity;

/**
 * @author LuoJu
 *
 * @since 2018.10.11
 *
 * json格式返回实体类
 */
public class Result {

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}