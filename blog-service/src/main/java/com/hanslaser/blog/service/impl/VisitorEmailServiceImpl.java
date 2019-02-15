package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.VisitorEmail;
import com.hanslaser.blog.entity.VisitorEmailLog;
import com.hanslaser.blog.entity.VisitorEmailRepository;
import com.hanslaser.blog.service.VisitorEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LuoJu
 * @since 2018.11.01
 */
@Service
@CacheConfig(cacheNames = "blogs")
@Transactional
public class VisitorEmailServiceImpl extends BaseServiceImpl<VisitorEmail> implements VisitorEmailService {

    @Autowired
    private VisitorEmailRepository visitorEmailRepository;

    @Override
    public void setBaseDAO() {
        setBaseDAO(visitorEmailRepository);
        setClazz(VisitorEmailLog.class);
    }

    @Override
    public String buildWhereSql(VisitorEmail t1, VisitorEmail t2) {
        return "";
    }

    @Override
    public VisitorEmail findByVisitorEmail(String email) {
        return visitorEmailRepository.findByVisitorEmail(email);
    }
}