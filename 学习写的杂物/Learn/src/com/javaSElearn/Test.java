package com.javaSElearn;

public class Test {
    public static void main(String[] args) {
        demo.showdata();
        demo.show1();
        demo.guessGame();
        demo.arrayDemo();
        demo.strCheck();
        demo.codeCheck();
//        demo d = new demo();
        //调用一个单例
//        singDemo ss = singDemo.singeel;
        //创建第二个对象，但是是和第一个对象是一样的
//        singDemo ss1 = singDemo.singeel;
//        ss.show();
        data dd = new data("小明", 18, '男');
        System.out.println(dd.getAge());
        System.out.println(dd.getName());
        System.out.println(dd.getSex());
        System.out.println(dd.toString());
        System.out.println(qqChaeck.checkQQ2("207260597"));
        file1Test.fileTest();
        file1Test.copyTest();
    }
}
