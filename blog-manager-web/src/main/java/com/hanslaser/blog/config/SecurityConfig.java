package com.hanslaser.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author LuoJu
 * @since 2018.10.29
 * Spring Security's config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationSuccessHandler mySuccessHandler() {
        return new MyAuthenticationSuccessHandler("/redirectToIndex");
    }

    @Bean
    public AuthenticationFailureHandler myFailureHandler() {
        return new MyAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login")
                .successHandler(mySuccessHandler())
                .failureHandler(myFailureHandler());

        http.logout()
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html", "/forgetPassword.html", "/modifyPassword.html", "/sendEmailWithVerifyCode", "/resetUserPassword",
                        "/css/**", "/images/**", "/js/**", "/views/**")
                .permitAll()
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();
    }
}
