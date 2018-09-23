package com.zhao.BasicUtilities;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-23 13:23
 * @描述     排序测试
 *          natural()	对可排序类型做自然排序，如数字按大小，日期按先后排序
            usingToString()	按对象的字符串形式做字典排序[lexicographical ordering]
            from(Comparator)	把给定的Comparator转化为排序器
 **/
public class OrderingTest {

    private static class Person {
        private int age;
        private String name;

        public Person(int age,String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void t1(){
        List<Person> personList = Arrays.asList(new Person(18,"zhao"),
                new Person(10,"zhang"),
                new Person(20,"li"),
                new Person(15,"wang"));
        //排序前
        System.out.println("---排序前---");
        System.out.println(personList);
        //Ordering<String> natural = Ordering.natural();
        Ordering<Object> usingToString = Ordering.usingToString();
        //按照age排序
        Ordering<Person> fromComparator = Ordering.from(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });

        //排序后
        System.out.println("---排序后---");
        System.out.println(usingToString.sortedCopy(personList));
        System.out.println(fromComparator.sortedCopy(personList));
        System.out.println(personList);
    }
}