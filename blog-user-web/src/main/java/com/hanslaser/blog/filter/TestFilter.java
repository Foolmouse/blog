package com.hanslaser.blog.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author LuoJu
 * @since 2018.11.14
 */
//@WebFilter(filterName = "testFilter", urlPatterns = "/*")
//public class TestFilter implements Filter {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("过滤器实例化");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("调用过滤器before...");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("调用过滤器after...");
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}