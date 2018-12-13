package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.vo.BaseModel;
import com.hanslaser.blog.exception.BlogException;
import com.hanslaser.blog.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * 通用service接口实现
 *
 * @author LuoJu
 * @since 2018.12.07
 */
@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    private JpaRepository baseDAO;

    public abstract void setBaseDAO();

    public void setBaseDAO(JpaRepository baseDao) {
        this.baseDAO = baseDao;
    }

    @Override
    public void add(T t) {
        setBaseDAO();
        t.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
        baseDAO.save(t);
    }

    @Override
    public void delete(Long id) {
        setBaseDAO();
        Optional optional = baseDAO.findById(id);
        if (optional.isPresent()) {
            BaseModel model = (BaseModel) optional.get();
            model.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
            baseDAO.delete(model);
        } else {
            throw new BlogException("id不存在");
        }
    }

    @Override
    public void update(T t) {
        setBaseDAO();
        t.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        baseDAO.save(t);
    }

    @Override
    public T get(Long id) {
        setBaseDAO();
        Optional optional = baseDAO.findById(id);
        if (optional.isPresent()) {
            return (T) optional.get();
        } else {
            throw new BlogException("id不存在");
        }
    }

    @Override
    public Page<T> findByPage(int currentPage, int pageSize, T t1, T t2) {
        setBaseDAO();
        PageRequest request = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "lastModifiedDatetime");
        Page<T> page = baseDAO.findAll(request);
        return page;
    }

}