package com.zhao.BasicUtilities;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-21 13:46
 * @描述      前置条件测试
 **/
public class PreconditionsTest {

    @Test
    public void t1(){
        checkArgument(false);
        System.out.println("为true才打印");
    }
}
