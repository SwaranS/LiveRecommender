package com.recommender.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * Created by swara on 16/01/2017.
 */
public class RecommenderCacheService {

    /**
     * Cache Manager
     */
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache("preConfigured",
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                            ResourcePoolsBuilder.heap(100))
                            .build())
            .build(true);
    Cache<Long, String> preConfigured
            = cacheManager.getCache("preConfigured", Long.class, String.class);
    Cache<Long, String> myCache = cacheManager.createCache("myCache",
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                    ResourcePoolsBuilder.heap(100)).build());


}
