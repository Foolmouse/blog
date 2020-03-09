package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.PortalLog;
import com.hanslaser.blog.entity.PortalLogRepository;
import com.hanslaser.blog.service.PortalLogService;
import com.hanslaser.blog.util.DateUtils;
import com.hanslaser.blog.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LuoJu
 * @since 2018.11.06
 */
@Service
//@Transactional
public class PortalLogServiceImpl implements PortalLogService {

    private int pageLimit = 5;

    @Autowired
    PortalLogRepository logRepository;

    @Override
    @Async
    public void log(HttpServletRequest request, String blogName) {
        PortalLog portalLog = new PortalLog();
        portalLog.setIp(IPUtils.getIpAddr(request));
        portalLog.setMethod(request.getMethod());
        portalLog.setUserAgent(request.getHeader("User-Agent"));
        portalLog.setRequestDateTime(DateUtils.getTimestamp());
        portalLog.setBlogName(blogName);
        logRepository.save(portalLog);
    }

    @Override
    public Page<PortalLog> findByPage(int currentPage, int pageSize) {
        PageRequest request = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "requestDateTime");
        Page<PortalLog> page = logRepository.findAll(request);
        return page;
    }

    @Override
    public void countStartEndPage(Map map, int pageTotal, int pageNum) {
        if (pageNum <= pageLimit) {
            map.put("startPage", 1);
            if (pageTotal <= pageNum + pageLimit) {
                map.put("endPage", pageTotal);
            } else {
                map.put("endPage", pageNum + pageLimit);
            }
        } else {
            map.put("startPage", pageNum - pageLimit);
            if (pageTotal <= pageNum + pageLimit) {
                map.put("endPage", pageTotal);
            } else {
                map.put("endPage", pageNum + pageLimit);
            }
        }
    }

}