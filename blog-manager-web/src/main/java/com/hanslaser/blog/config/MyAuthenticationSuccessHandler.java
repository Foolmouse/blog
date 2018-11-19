package com.hanslaser.blog.config;

import com.hanslaser.blog.entity.LoginLog;
import com.hanslaser.blog.service.LoginLogService;
import com.hanslaser.blog.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * SpringSecurity验证成功处理器
 *
 * @author LuoJu
 * @since 2018.11.16
 */
public class MyAuthenticationSuccessHandler extends ForwardAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LoginLogService logService;

    /**
     * @param forwardUrl
     */
    public MyAuthenticationSuccessHandler(String forwardUrl) {
        super(forwardUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("username:" + request.getParameter("username"));
        String remoteHost = request.getRemoteHost();
        String userAgent = request.getHeader("User-Agent");
        String method = request.getMethod();
        String username = authentication.getName();

        LoginLog loginLog = new LoginLog();
        loginLog.setUserName(username);
        loginLog.setBrowserInfo(userAgent);
        loginLog.setIp(remoteHost);
        loginLog.setLoginDateTime(DateUtils.getTimestamp());
        loginLog.setMethod(method);

        //todo remember me时间设置
        //setSessionMaxInactiveInterval(request);

        loginLog.setIsLoginSuccess("登录成功");
        logService.create(loginLog);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}