package com.hanslaser.blog.controller;

import com.hanslaser.blog.service.PortalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于index模板跳转其他子页面
 *
 * @author LuoJu
 * @since 2018.12.10
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private PortalLogService portalLogService;

    @RequestMapping("/addBlog")
    public String toAddBlog() {
        return "redirect:/blog/create";
    }

    @RequestMapping("/blogList")
    public String toBlogList() {
        return "redirect:/blog/findPage";
    }

    @RequestMapping("/addBlogCategory")
    public String toAddBlogCategory() {
        return "redirect:/category/create";
    }

    @RequestMapping("/blogCategoryList")
    public String toBlogCategoryList() {
        return "redirect:/category/findPage";
    }

    @RequestMapping("/stats")
    public String toStats() {
        return "stats";
    }

    @RequestMapping("/form")
    public String toForm() {
        return "form";
    }

    @RequestMapping("/tables")
    public String toTables() {
        return "tables";
    }

    @RequestMapping("/portalLog")
    public String toPortalLog() {
        return "redirect:/portalLog/findPage";
    }

    @RequestMapping("/loginLog")
    public String toLoginLog() {
        return "redirect:/loginLog/findPage";
    }

    @RequestMapping("/buttons")
    public String toButtons() {
        return "buttons";
    }

    @RequestMapping("/editor")
    public String toEditor() {
        return "editor";
    }

    @RequestMapping("/interface")
    public String toInterface() {
        return "interface";
    }

}