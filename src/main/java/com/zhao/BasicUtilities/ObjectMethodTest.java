package com.zhao.BasicUtilities;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-21 13:50
 * @描述      常见的Objects中的方法
 **/
public class ObjectMethodTest {

    @Test
    public void testEquals(){
        System.out.println(Objects.equal(null,null));
    }

    @Test
    public void testHashCode(){
        System.out.println(Objects.hashCode("a",1));
    }

    @Test
    public void testoString(){
        System.out.println( Objects.toStringHelper(this).add("x", 1).toString());
    }

    @Test
    public void testComparisonChain(){
         Person p1 = new Person("a","d","e");
         Person p2 = new Person("a","c","e");
         Person p3 = new Person("f","d","b");

         List<Person> list = Arrays.asList(p1,p2,p3);
         //排序前
         System.out.println(list);

         Collections.sort(list);
         //排序后
         System.out.println(list);
    }


    class Person implements Comparable<Person> {
        private String one;
        private String two;
        private String three;

        public Person(String one,String two,String three){
            this.one = one;
            this.two = two;
            this.three = three;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "one='" + one + '\'' +
                    ", two='" + two + '\'' +
                    ", three='" + three + '\'' +
                    '}';
        }
        /**
        * @描述  按照one，two，three的顺序比较
        * @参数 [o]
        * @返回值 int
        */
        @Override
        public int compareTo(Person o) {

            //方式1：普通比较

            //int compareResult = this.one.compareTo(o.one);
            //if(compareResult!=0){
            //    return compareResult;
            //}
            //compareResult = this.two.compareTo(o.two);
            //if(compareResult!=0){
            //    return compareResult;
            //}
            //return this.three.compareTo(o.three);


            //方式2：ComparisonChain
            return  ComparisonChain.start()
                    .compare(one,o.one)
                    .compare(two,o.two)
                    .compare(three,o.three, Ordering.natural().nullsLast()).result();
        }
    }

}