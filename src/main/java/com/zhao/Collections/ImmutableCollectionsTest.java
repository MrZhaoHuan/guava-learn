package com.zhao.Collections;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.io.Serializable;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-21 17:20
 * @描述      不可变集合测试
 **/
public class ImmutableCollectionsTest {

    @Test
    public void t1(){
        //set
        ImmutableSet<Integer> set = ImmutableSet.of(3, 2, 3);
        System.out.println(set);

        //map
        ImmutableMap<String, ? extends Serializable> map = ImmutableMap.of("name", "zhao", "age", 18);
        System.out.println(map);

        //sortedSet
        ImmutableSortedSet<Integer> sortedSet = ImmutableSortedSet.of(1, 3, 3, 2);
        System.out.println(sortedSet);

        //链式调用builder
        ImmutableSet<Object> buildSet = ImmutableSet.builder()
                .add(1)
                .add(3)
                .add(2)
                .add(2)
                .build();
        System.out.println(buildSet);


    }
}
