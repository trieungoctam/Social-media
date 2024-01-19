package com.dynamite.facebook.util;

import com.dynamite.facebook.service.ICacheService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadingCacheStore<T> {
    private final LoadingCache<Long, T> loadingCache;

    public LoadingCacheStore(int expiryDuration, TimeUnit timeUnit, ICacheService<T> service) {
        CacheLoader<Long, T> load = new CacheLoader<>() {
            @Override
            public T load(Long key) throws Exception {
                return service.getBackendData(key);
            }
        };

        loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(expiryDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build(load);
    }
    public T get(Long key) throws ExecutionException {
        return loadingCache.get(key);
    }
    public void put(Long key, T value){
        loadingCache.put(key, value);
    }
}
