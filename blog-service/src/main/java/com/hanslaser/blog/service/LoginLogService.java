package com.hanslaser.blog.service;

import com.hanslaser.blog.entity.LoginLog;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @author LuoJu
 * @since 2018.11.1
 * Blog Service接口
 */
public interface LoginLogService {

    /**
     * create login log
     * @param loginLog
     * @return
     */
    LoginLog create(LoginLog loginLog);

    Page<LoginLog> findByPage(int currentPage, int pageSize);

    /**
     * 放入开始分页和结束分页页码
     */
    void countStartEndPage(Map map, int pageTotal , int pageNum);
}