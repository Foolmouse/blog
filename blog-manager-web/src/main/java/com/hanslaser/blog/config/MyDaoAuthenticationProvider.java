package com.hanslaser.blog.config;

import com.hanslaser.blog.entity.LoginLog;
import com.hanslaser.blog.service.LoginLogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;

/**
 * Overwrite {@link DaoAuthenticationProvider} authenticate method use for record User's login log;
 *
 * @author DunkLuo
 * @since 2018.11.15
 */
//@Component
public class MyDaoAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    LoginLogService logService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        HttpServletRequest request = (HttpServletRequest) authentication.getDetails();
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
        String errorMessage;//错误信息
        Authentication returnAuthentication;
        try {
            returnAuthentication = super.authenticate(authentication);

            //todo remember me时间设置
            //setSessionMaxInactiveInterval(request);

            loginLog.setIsLoginSuccess("登录成功");
            logService.create(loginLog);
        } catch (AuthenticationException e) {
            loginLog.setIsLoginSuccess("登录失败");
            errorMessage = e.getMessage();
            loginLog.setErrorMessage(errorMessage);
            logService.create(loginLog);
            throw e;
        }

        return returnAuthentication;
    }

    private void setSessionMaxInactiveInterval(HttpServletRequest request) {
        int defaultSessionMaxInactiveInterval = 1800;

        try {
            String rememberMe = request.getParameter("remember-me");
            String rememberDays = request.getParameter("rememberDays");
            if (request.getSession() != null) {
                if (rememberMe != null) {
                    request.getSession().setMaxInactiveInterval(Integer.valueOf(rememberDays) * 60 * 60 * 24);
                } else {
                    request.getSession().setMaxInactiveInterval(defaultSessionMaxInactiveInterval);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (request.getSession() != null) {
                request.getSession().setMaxInactiveInterval(defaultSessionMaxInactiveInterval);
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
