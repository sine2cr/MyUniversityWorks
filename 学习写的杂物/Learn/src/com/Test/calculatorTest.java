package com.Test;


import com.javaWebLearn.calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class calculatorTest {
    /**
     * junit单元测试
     * 1、定义一个测试类
     * 建议测试类名为：被测试的类名Test
     * 建议包名为：xx.xx.xxx.test
     * 2、定义测试方法
     * 建议方法名：test测试的方法名
     * 返回值：void
     * 参数列表：null
     * 3、给方法加@Test
     * 导入junit依赖环境
     */
    /**
     * 初始化方法
     * 用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init() {
        System.out.println("初始化方法执行了");
    }

    //    释放资源方法
    //  在所有测试方法执行完之后都会自动执行该方法
    @After
    public void over() {
        System.out.println("资源释放方法执行了");
    }

    @Test
    public void testadd() {
        calculator c = new calculator();
        int result = c.add(1, 2);
        System.out.println(result);
        System.out.println(result);
        //断言
        //Assert.assertEquals(期望结果,最终结果);

        Assert.assertEquals(3, result);

    }
}
