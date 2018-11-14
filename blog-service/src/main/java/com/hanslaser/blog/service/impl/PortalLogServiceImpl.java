package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.PortalLog;
import com.hanslaser.blog.entity.PortalLogRepository;
import com.hanslaser.blog.service.PortalLogService;
import com.hanslaser.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LuoJu
 * @since 2018.11.06
 */
@Service
@Transactional
public class PortalLogServiceImpl implements PortalLogService {

    @Autowired
    PortalLogRepository logRepository;

    @Override
    public void log(HttpServletRequest request , String blogName) {
        PortalLog portalLog = new PortalLog();
        portalLog.setIp(request.getRemoteHost());
        portalLog.setMethod(request.getMethod());
        portalLog.setUserAgent(request.getHeader("User-Agent"));
        portalLog.setRequestDateTime(DateUtils.getTimestamp());
        logRepository.save(portalLog);
    }

}