package com.zhao.Collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-21 17:36
 * @描述      新型集合:  Multiset
                        Multimap
                        BiMap
                        Table
                        ClassToInstanceMap
                        RangeSet
                        RangeMap
 **/
public class NewCollectionTypesTest {
        /**
        * @描述  HashMultiset
        * @参数 []
        * @返回值 void
        */
       @Test
       public void t1(){
           HashMultiset<Integer> hashMultiset = HashMultiset.create();
           hashMultiset.add(1);
           hashMultiset.add(2);
           hashMultiset.add(1);

           //元素1出现的次数
           System.out.println(hashMultiset.count(1));

           //设置元素2的数量为5
           hashMultiset.setCount(2,5);
           System.out.println(Arrays.toString(hashMultiset.toArray()));
       }

        /**
         * @描述  ArrayListMultimap
         * @参数 []
         * @返回值 void
         */
        @Test
        public void t2(){
            ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
            multimap.put("zhao_have","money");
            multimap.put("zhao_have","phone");

            List<String> zhao_have = multimap.get("zhao_have");
            System.out.println(zhao_have);
        }


        /**
         * @描述  HashBiMap-双向映射（值必须是唯一的）
         * @参数 []
         * @返回值 void
         */
        @Test
        public void t3(){
            BiMap<String, Integer> name_userId = HashBiMap.create();
            name_userId.put("zhao",18);
            System.out.println(name_userId);

            //反转
            BiMap<Integer, String> userId_name = name_userId.inverse();
            System.out.println(userId_name.get(18));
        }

}