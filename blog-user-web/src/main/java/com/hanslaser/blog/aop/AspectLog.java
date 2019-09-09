package com.hanslaser.blog.aop;

import com.hanslaser.blog.entity.PortalLog;
import com.hanslaser.blog.util.DateUtils;
import com.hanslaser.blog.util.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: create by LuoJu
 * @date:2019/4/2
 * @description: com.hanslaser.blog.aop 全局请求统一日志
 */
public class AspectLog {

    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.hanslaser.blog.controller..*.*(..))")
    public void webLog(){}


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        PortalLog log = new PortalLog();
        log.setIp(IPUtils.getIpAddr(request));

        log.setMethod(request.getMethod());
        log.setUserAgent(request.getHeader("User-Agent"));
        log.setRequestDateTime(DateUtils.getTimestamp());


    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }



}
