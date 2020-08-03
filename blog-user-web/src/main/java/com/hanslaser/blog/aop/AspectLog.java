package com.hanslaser.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: create by LuoJu
 * @date:2019/4/2
 * @description: com.hanslaser.blog.aop 全局请求统一日志
 */
@Component
@Aspect
@Order(1)
public class AspectLog {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.hanslaser.blog.controller..*.*(..))")
    public void webLog() {}

//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //long startTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        //long endTime = System.currentTimeMillis();

        // 记录下请求内容
        //logger.info("URL : " + request.getRequestURL().toString() + "===" + request.getMethod());
        //logger.info("IP : " + request.getRemoteAddr());
        //logger.info("CLASS_METHOD : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        //logger.info("ARGS : " + Arrays.toString(point.getArgs()));
        //logger.info("请求耗时：{}", endTime - startTime);

        return proceed;
    }

//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//    }

}
