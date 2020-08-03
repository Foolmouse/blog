package com.hanslaser.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: create by LuoJu
 * @date:2019/3/27
 * @description: 全局拦截器,可输出请求日志
 * 已使用aop记录日志
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    private static ConcurrentHashMap map = new ConcurrentHashMap();

    /**
     * 在业务处理器处理请求之前被调用
     *
     * @param request  注意，拦截器在过滤器之后调用，此时request变成了HttpServletRequest
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(handler.getClass());
        map.put(request, System.currentTimeMillis());
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        Long handleTime = System.currentTimeMillis() - (Long) map.get(request);
        logger.info("afterCompletion用时" + handleTime);
        map.remove(request);
    }

}

