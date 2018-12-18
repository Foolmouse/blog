package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.PortalLog;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * description: record request log of blog portal page of service interface;
 *
 * @author LuoJu
 * @since 2018.11.06
 */
public interface PortalLogService {
    /**
     * 新增门户访问记录
     *
     * @param request
     */
    void log(HttpServletRequest request, String blogName);

    /**
     * 分页查询访问记录
     */
    Page<PortalLog> findByPage(int currentPage, int pageSize);

    /**
     * 放入开始分页和结束分页页码
     */
    void countStartEndPage(Map map, int pageTotal , int pageNum);

}
