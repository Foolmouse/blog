package com.hanslaser.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * portal module
 *
 * @author LuoJu
 * @since 2020.03.07
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)      //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.BAD_REQUEST)     //表示设置状态码。
    Result handleException() {
        return new Result(500, "服务器错误");
    }

    private class Result {
        int code;
        String message;

        public Result(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}