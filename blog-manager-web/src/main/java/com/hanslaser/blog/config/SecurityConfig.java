package com.hanslaser.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author LuoJu
 * @since 2018.10.29
 * Spring Security's config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()                        //  定义当需要用户登录时候，转到的登录页面。
                .successForwardUrl("/redirectToIndex")
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html", "/css/**", "/images/**", "/js/**", "/views/**").permitAll()
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();

    }
}
