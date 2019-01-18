package com.hanslaser.blog.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * service层通用接口
 *
 * @author LuoJu
 * @since 2018.12.07
 */
public interface BaseService<T> {

    void add(T t);

    void delete(String ids);

    void delete(Long id);

    void update(T t);

    T get(Long id);

    List<T> getAll();

    Page<T> findByPage(int currentPageNumber, int numberPerPage, T t1, T t2);

    /**
     * 根据实体类属性映射sql
     *
     * @param t1
     * @param t2
     * @return
     */
    String buildWhereSql(T t1, T t2);

    /**
     * 放入开始分页和结束分页页码
     */
    void countStartEndPage(Map map, int pageTotal , int pageNum);

}
