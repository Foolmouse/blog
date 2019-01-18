package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.entity.vo.BaseModel;
import com.hanslaser.blog.exception.BlogException;
import com.hanslaser.blog.service.BaseService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    private int pageLimit = 5;

    private Class clazz;

    public abstract void setBaseDAO();

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setBaseDAO(JpaRepository baseDao) {
        this.baseDAO = baseDao;
    }

    @Override
    public void add(T t) {
        setBaseDAO();
        t.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
        t.setDr(0);
        baseDAO.save(t);
    }

    @Override
    public void delete(Long id) {
        setBaseDAO();
        Optional optional = baseDAO.findById(id);
        if (optional.isPresent()) {
            BaseModel model = (BaseModel) optional.get();
            model.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));

            //baseDAO.delete(model);

            model.setDr(1);
            baseDAO.save(model);
        } else {
            throw new BlogException("id不存在");
        }
    }

    @Override
    public void delete(String ids) {
        if (!StringUtils.isEmpty(ids)) {
            String[] arrIds = ids.split(",");
            for (String arrId : arrIds) {
                delete(Long.parseLong(arrId));
            }
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

    /**
     * @return 允许返回一个非NULL空集合
     */
    @Override
    public List<T> getAll() {
        setBaseDAO();
        ExampleMatcher matcher = ExampleMatcher.matching();

        Example<BaseModel> example = Example.of(buildDrInstance(), matcher);
        List<T> list = baseDAO.findAll(example);
        if (null != list) {
            return list;
        }
        return new ArrayList<>();
    }

    /**
     * 只查询dr为0的数据
     *
     * @param currentPage
     * @param pageSize
     * @param t1
     * @param t2
     * @return
     */
    @Override
    public Page<T> findByPage(int currentPage, int pageSize, T t1, T t2) {
        setBaseDAO();
        PageRequest request = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "lastModifiedDatetime");

        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<BaseModel> example = Example.of(buildDrInstance(), matcher);

        Page<T> page = baseDAO.findAll(example, request);
        return page;
    }

    /**
     * 反射构建实体,dr=0
     *
     * @return
     */
    private BaseModel buildDrInstance() {
        BaseModel baseModel = null;
        try {
            baseModel = (BaseModel) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        baseModel.setDr(0);
        return baseModel;
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