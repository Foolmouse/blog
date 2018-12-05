package com.hanslaser.blog.config;

import com.hanslaser.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author LuoJu
 * @since 2018.10.29
 * Default implements of {@link UserDetailsService}
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", userNameOrEmail);
        com.hanslaser.blog.entity.User user = userService.findUserByUserNameOrEmail(userNameOrEmail);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + userNameOrEmail);
        } else {
            //会在这里对用户密码进行校验,并授予'admin'角色
            return new User(userNameOrEmail, user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
    }
}