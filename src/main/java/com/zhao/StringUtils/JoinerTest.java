package com.zhao.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-23 19:36
 * @描述
 **/
public class JoinerTest {

    //todo: Joiner
    @Test
    public void t1() {
        String str = Joiner.on(',').skipNulls().join(Arrays.asList("a", null, "b"));
        System.out.println(str);  //a,b

        String str2 = Joiner.on(',').useForNull("代替null值").join(Arrays.asList("a", null, "b"));
        System.out.println(str2);  //a,代替null值,b
    }


    //todo: Splitter
    /**
         omitEmptyStrings()	从结果中自动忽略空字符串
         trimResults()	移除结果字符串的前导空白和尾部空白
         trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
         limit(int)	限制拆分出的字符串数量
    */
    @Test
    public void t2() {
        Iterable<String> list = Splitter.on(",")
                .omitEmptyStrings()
                //.limit(2)
                 .trimResults()
                .split("foo,bar,, qux");
        for(String value : list){
            System.out.println(value);
        }
    }
}
