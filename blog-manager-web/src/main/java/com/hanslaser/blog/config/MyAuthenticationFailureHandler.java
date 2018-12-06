package com.hanslaser.blog.config;

import com.hanslaser.blog.entity.LoginLog;
import com.hanslaser.blog.service.LoginLogService;
import com.hanslaser.blog.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpringSecurity Authentication failure handler
 * @author LuoJu
 * @since 2018.11.16
 */
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginLogService logService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("username:" +request.getParameter("username"));

        String remoteHost = request.getRemoteHost();
        String userAgent = request.getHeader("User-Agent");
        String method = request.getMethod();
        String userName = request.getParameter("username");
        String errorMessage = exception.getMessage();

        LoginLog loginLog = new LoginLog();
        loginLog.setUserName(userName);
        loginLog.setBrowserInfo(userAgent);
        loginLog.setIp(remoteHost);
        loginLog.setLoginDateTime(DateUtils.getTimestamp());
        loginLog.setMethod(method);
        loginLog.setIsLoginSuccess("登陆失败");
        loginLog.setErrorMessage(errorMessage);

        logService.create(loginLog);

        super.onAuthenticationFailure(request, response, exception);
    }
}