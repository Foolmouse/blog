package com.hanslaser.blog.config;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * 用于处理redis注解抛出的异常,如果不配置此类,那么异常将会直接抛出
 * 在异常中做记载,以后打入系统日志
 *
 * @author LuoJu
 * @since 2019.02.13
 */
@Configuration
public class MyCacheConfiguer extends CachingConfigurerSupport {



    @Override
    @Bean
    public CacheErrorHandler errorHandler() {
        // 异常处理，当Redis发生异常时，打印日志，但是程序正常走
        CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                System.err.println("===========redis connect exception=========");
            }
            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                System.err.println("===========redis connect exception=========");
            }
            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                System.err.println("===========redis connect exception=========");
            }
            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                System.err.println("===========redis connect exception=========");
            }
        };
        return cacheErrorHandler;

    }
}