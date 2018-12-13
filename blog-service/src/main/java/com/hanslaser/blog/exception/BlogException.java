package com.hanslaser.blog.exception;

public class BlogException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BlogException(String message) {
        super(message);
    }
}