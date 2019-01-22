package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.Category;
import com.hanslaser.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客分类接口
 *
 * @author LuoJu
 * @since 2018.01.16
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private final static String REDIRECT_INDEX = "redirect:/index";
    private final static String REDIRECT_BLOG_CATEGORY_LIST = "redirect:/category/findPage";
    private final static String BLOG_CATEGORY_LIST = "blogCategoryList";
    private final static String BLOG_CATEGORY_FORM = "blogCategoryForm";

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取创建 Category 表单 , 放入一个无数据对象
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCategoryForm(ModelMap map) {
        map.addAttribute("category", new Category());
        map.addAttribute("action", "create");
        return BLOG_CATEGORY_FORM;
    }

    /**
     * 创建 Category
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCategory(@ModelAttribute Category category) {
        categoryService.add(category);
        return REDIRECT_BLOG_CATEGORY_LIST;
    }

    /**
     * 更新 Category
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putCategory(@ModelAttribute Category category) {
        categoryService.update(category);
        return REDIRECT_BLOG_CATEGORY_LIST;
    }

    /**
     * 删除 Category
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Long id, ModelMap map) {
        categoryService.delete(id);
        return REDIRECT_BLOG_CATEGORY_LIST;
    }

    /**
     * 根据id查询Category , 回显数据
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getCategory(@PathVariable Long id, ModelMap map) {
        map.put("category", categoryService.get(id));
        map.put("action", "update");
        return BLOG_CATEGORY_FORM;
    }

    /**
     * 获取所有CategoryList
     */
    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public String getAllCategory(ModelMap map, @RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Category> page = categoryService.findByPage(pageNum - 1, pageSize, null, null);
        //总条数
        map.put("total", page.getTotalElements());
        //每页数量
        map.put("pageSize", pageSize);
        //总页数
        map.put("totalPages", page.getTotalPages());
        //内容
        map.put("content",  page.getContent());
        //当前页
        map.put("pageNum", pageNum);

        //是否第一页
        map.put("isFirstPage", page.isFirst());
        //是否最后一页
        map.put("isLastPage", page.isLast());
        return BLOG_CATEGORY_LIST;
    }

}