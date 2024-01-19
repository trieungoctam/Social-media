package com.dynamite.facebook.config;

import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.service.ICacheService;
import com.dynamite.facebook.util.LoadingCacheStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreBeans {
    @Bean
    public LoadingCacheStore<User> userLoadingCache(ICacheService<User> userCacheService) {
        return new LoadingCacheStore<>(1, TimeUnit.HOURS, userCacheService);
    }
    @Bean
    public LoadingCacheStore<Post> postLoadingCache(ICacheService<Post> postCacheService) {
        return new LoadingCacheStore<>(10, TimeUnit.MINUTES, postCacheService);
    }
}
