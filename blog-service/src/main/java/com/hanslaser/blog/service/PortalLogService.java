package com.hanslaser.blog.service;

import javax.servlet.http.HttpServletRequest;

/**
 * description: request record log of blog portal page of service interface;
 *
 * @author LuoJu
 * @since 2018.11.06
 */
public interface PortalLogService {
    /**
     * 记录访问日志
     *
     * @param request
     */
    public void log(HttpServletRequest request, String blogName);
}
