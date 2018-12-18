package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.LoginLog;
import com.hanslaser.blog.entity.LoginLogRepository;
import com.hanslaser.blog.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author LuoJu
 * @since 2018.11.17
 */
@Service
@Transactional
public class LoginLogServiceImpl implements LoginLogService {

    private int pageLimit = 5;

    @Autowired
    private LoginLogRepository logRepository;

    @Override
    public LoginLog create(LoginLog loginLog) {
        return logRepository.save(loginLog);
    }

    @Override
    public Page<LoginLog> findByPage(int currentPage, int pageSize) {
        PageRequest request = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "loginDateTime");
        Page<LoginLog> page = logRepository.findAll(request);
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