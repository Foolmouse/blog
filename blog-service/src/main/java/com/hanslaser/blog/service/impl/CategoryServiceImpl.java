package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.Blog;
import com.hanslaser.blog.entity.Category;
import com.hanslaser.blog.entity.CategoryRepository;
import com.hanslaser.blog.service.BlogService;
import com.hanslaser.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author LuoJu
 * @since 2018.01.16
 */
@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogService blogService;

    @Override
    public void setBaseDAO() {
        setBaseDAO(categoryRepository);
        setClazz(Category.class);
    }

    @Override
    public String buildWhereSql(Category t1, Category t2) {
        return "";
    }

    @Override
    public void add(Category category) {
        if (checkNumIsDuplicate(category.getNum())) {
            super.add(category);
        }
    }

    @Override
    public void update(Category category) {
        if (checkNumIsDuplicate(category.getNum())) {
            super.update(category);
        }
    }

    @Override
    public void delete(Long id) {
        List<Blog> byCategoryId = blogService.findByCategoryId(id);
        if (null != byCategoryId && byCategoryId.size() != 0) {
            return;
        }
        super.delete(id);
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = super.getAll();
        for (Category category : categoryList) {
            List<Blog> byCategoryId = blogService.findByCategoryId(category.getId());
            if (!CollectionUtils.isEmpty(byCategoryId)) {
                category.setTotalNum(byCategoryId.size());
            }
        }
        return categoryList;
    }

    private boolean checkNumIsDuplicate(Integer num) {
        if (null != num) {
            Category byNum = categoryRepository.findByNum(num);
            if (null != byNum) {
                return false;
            }
            return true;
        }
        return false;
    }
}