package com.hanslaser.blog.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LuoJu
 * @since 2018.11.14
 */
@WebFilter(filterName = "portalLogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            logger.info("remoteHost:" + request.getRemoteHost());
            logger.info("browser information:" + request.getHeader("User-Agent"));
            logger.info("request method:" + request.getMethod());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}