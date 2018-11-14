package com.hanslaser.blog.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

/**
 * @author LuoJu
 * @since 2018.11.14
 */
@Configuration
public class loginConfig {

    /*@Bean
    public FilterRegistrationBean setFilter(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new OpenSessionInViewFilter());
        filterBean.setName("FilterController");
        filterBean.addUrlPatterns("/*");
        return filterBean;
    }*/
}