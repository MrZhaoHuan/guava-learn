package com.zhao.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-23 18:26
 * @描述      guava本地缓存测试
 **/
public class LoadingCacheTest {
    private LoadingCache<String,Object> cache;
    @Before
    public void before(){
        cache = CacheBuilder.newBuilder().build(
                new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        System.out.println("---执行---");
                        return key+":"+key;
                    }

                    //重写loadAll，批量加载key
                    @Override
                    public Map<String, Object> loadAll(Iterable<? extends String> keys) throws Exception {
                        System.out.println("---批量执行---");
                        Map<String, Object> map = new HashMap<>();
                        for(String key:keys){
                            map.put(key,key+"___批量___"+key);
                        }
                        return map;
                    }
                }
        );
    }

    //todo:// cacheLoader
    @Test
    public void t1() throws ExecutionException {
        System.out.println(cache.getClass());
        /**
             load方法执行一次
             ---执行---
             zhao:zhao

             System.out.println(cache.get("zhao"));
             System.out.println(cache.get("zhao"));
        */
        cache.put("zhao","hello");
        System.out.println(cache.get("zhao"));
        //使用getAll，如果CacheLoader实例重写了loadAll方法,默认会调用loadAll方法,否则调用load方法
        ImmutableMap<String, Object> manyKeyValues = cache.getAll(Arrays.asList("wang", "xiao"));
        System.out.println(manyKeyValues);

        //在所有key中，没有缓存过的key，才会调用loadAll去加载
        System.out.println(cache.getAll(Arrays.asList("zhao","none")));
    }


    //todo:// callable callback
    @Test
    public void t2() throws ExecutionException {
        Cache<String, Object> cache = CacheBuilder
                                        .newBuilder()
                                        .maximumSize(2)   //缓存的最大容量
                                        .build();

        String key =  "zhao";

        Object value = cache.get(key, new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return key + "___callable__" + key;
            }
        });

        System.out.println(value);
    }

    /**
         todo://清除缓存项

         个别清除：Cache.invalidate(key)
         批量清除：Cache.invalidateAll(keys)
         清除所有缓存项：Cache.invalidateAll()
    */
    @Test
    public void t3() throws ExecutionException {
        //cache.refresh("zhao");

        cache.put("zhao","666");
        System.out.println(cache.get("zhao"));
        cache.invalidate("zhao");
        System.out.println(cache.get("zhao"));
    }
}