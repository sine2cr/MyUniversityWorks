package com.javaSElearn;

public class singDemo {
    /**
     *定义一个公开的静态的成员变量储存一个类的对象
     *这里初始化一个公开的对象使其进行一个合理暴露
     *
    */
    public static singDemo singeel =new singDemo();
    public singDemo singeel1 =new singDemo();

    /**
     *构造器私有使其不能构造对象
     *
     */
    private singDemo(){

    }
    public void show(){
        System.out.println("实例类输出数据");
    }

}
