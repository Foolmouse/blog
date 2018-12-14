package com.hanslaser.blog.controller;

import com.hanslaser.blog.entity.PortalLog;
import com.hanslaser.blog.service.PortalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PortalLog's controller
 *
 * @author LuoJu
 * @since 2018.10.11
 */
@Controller
@RequestMapping("/portalLog")
public class PortalLogController {

    private final static String PORTALLOG_LIST = "portalLog";

    @Autowired
    private PortalLogService portalLogService;

    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public String getAllBlog(ModelMap map, @RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<PortalLog> page = portalLogService.findByPage(pageNum - 1, pageSize);
        //总条数
        map.put("total", page.getTotalElements());
        //每页数量
        map.put("pageSize", pageSize);
        //总页数
        map.put("totalPages", page.getTotalPages());
        //内容
        map.put("content", page.getContent());
        //当前页
        map.put("pageNum", pageNum);
        //是否第一页
        map.put("isFirstPage", page.isFirst());
        //是否最后一页
        map.put("isLastPage", page.isLast());
        return PORTALLOG_LIST;
    }

}