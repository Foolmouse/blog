package com.hanslaser.blog.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * OverWriter {@link AuthenticationDetailsSource}.As change the AuthenticationDetails
 *
 * @author LuoJu
 * @since 2018.11.15
 */
public class MyAuthenticationDetailsSource implements AuthenticationDetailsSource {

    private HttpServletRequest request;

    @Override
    public HttpServletRequest buildDetails(Object context) {
        if (null != context && context instanceof HttpServletRequest) {
            return (HttpServletRequest) context;
        }
        return this.getRequest();
    }

    public HttpServletRequest getRequest() {
        return request;
    }
}