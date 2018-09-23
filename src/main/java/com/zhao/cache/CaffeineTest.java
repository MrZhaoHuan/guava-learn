package com.zhao.cache;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-23 22:27
 * @描述      Caffeine库
 **/
public class CaffeineTest {
    Cache<String, String> cache;  //同步方式

    AsyncLoadingCache<String,String> asyncCache;  //异步方式

    @Before
    public void before(){
        cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();


        asyncCache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .buildAsync(key -> {
                    System.out.println("异步方式：缓存中没有key:"+key);
                    return key;
                });
    }

    //todo: getIfPresent(key)
    @Test
    public void t1(){
        System.out.println(cache.getIfPresent("name"));  //null
    }

    //todo: get(key,Function)  -  get方法可以原子方式执行计算，线程安全，优于 getIfPresent
    @Test
    public void t2(){
        String value = cache.get("name", key -> {
                    System.out.println("缓存中没有key:"+key);
                    return key + "的值";
                }

                //new Function<String, String>() {
                //        @Override
                //        public String apply(String key) {
                //            System.out.println("缓存中没有key:"+key);
                //            return key + "的值";
                //        }
                //}

        );

        System.out.println(value);
        System.out.println(value);
    }

    //todo: 异步方式
    @Test
    public void t3(){
        CompletableFuture<String> name = asyncCache.get("name");
        System.out.println(name.getNow("默认值"));
    }
}