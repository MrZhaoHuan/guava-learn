package com.zhao.BasicUtilities;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-21 13:34
 * @描述   空值处理
 **/
public class OptionTest {

    @Test
    public void t1(){
        Optional<Integer> number = Optional.of(18);

        System.out.println(number.getClass());
        System.out.println(number.isPresent());
        System.out.println(number.get());
    }
}