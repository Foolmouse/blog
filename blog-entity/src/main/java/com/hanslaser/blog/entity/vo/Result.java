package com.hanslaser.blog.entity.vo;

/**
 * 描述：springMVC json数据返回类
 *
 * @author LuoJu_123855
 * @since 2018.07.24
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