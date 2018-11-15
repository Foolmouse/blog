package com.hanslaser.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author LuoJu
 * @since 2018.10.29
 * Spring Security's config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    /**
     * 负责验证的过滤器UsernamePasswordAuthenticationFilter持有AuthenticationManager,它持有一个AuthenticationProvider集合,负责具体的验证
     * @param auth
     * @throws Exception
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        //auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(daoAuthenticationProvider);

    }*/

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new MyDaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(daoAuthenticationProvider);

        FormLoginConfigurer<HttpSecurity> configurer = http.formLogin();
        configurer.successForwardUrl("/redirectToIndex").loginPage("/login.html").loginProcessingUrl("/login").and();
        configurer.authenticationDetailsSource(new MyAuthenticationDetailsSource());
        http.logout()
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html","/forgetPassword.html","/modifyPassword.html","/sendEmailWithVerifyCode","/verityCode",
                        "/css/**", "/images/**", "/js/**", "/views/**")
                .permitAll()
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();

    }
}
