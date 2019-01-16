package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Category;
import com.hanslaser.blog.entity.CategoryRepository;
import com.hanslaser.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LuoJu
 * @since 2018.01.16
 */
@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void setBaseDAO() {
        setBaseDAO(categoryRepository);
    }

    @Override
    public String buildWhereSql(Category t1, Category t2) {
        return "";
    }
}