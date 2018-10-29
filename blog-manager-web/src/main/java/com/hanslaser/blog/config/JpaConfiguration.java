package com.hanslaser.blog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: JpaConfiguration
 * @Description: Jpa的配置类。
 * @EnableTransactionManagement 启用了JPA 的事务管理
 * @EnableJpaRepositories 启用了JPA资源库并指定了上面定义的接口资源库的位置
 * @EntityScan 指定了定义实体的位置
 * @Configuration可理解为xml中的<beans></beans>
 * @Bean可理解为xml中的<bean></bean>
 * @author gongli
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.hanslaser.blog.entity")
@EntityScan(basePackages = "com.hanslaser.blog.entity")
public class JpaConfiguration {
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}