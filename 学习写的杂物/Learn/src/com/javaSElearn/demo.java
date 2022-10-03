package com.javaSElearn;


import java.util.Random;
import java.util.Scanner;

/**
 * @author BeiCe
 * @apiNote 函数实践
 */
public class demo {
    private static int data = 589;

    private static int ge = data % 10;
    private static int shi = data / 10 % 10;


    private static int bai = data / 100;

    public static void showdata() {
        System.out.println("个位:" + ge + "十位:" + shi + "百位:" + bai);
    }

    public static void show1() {
        double score = 98;
        String rs = score >= 60 ? "考试通过" : "挂科";
        System.out.println(rs);
    }
    //静态代码块在类创建时候就执行，常用于静态数据的加载以便后续使用
    static {
        System.out.println("执行静态代码块");
    }
    //构造代码块与对象一起加载
    {
        System.out.println("构造代码块被执行");
    }
    public static void interper() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("你的年龄是：" + age);
        System.out.println("请输入你的姓名：");
        String name = sc.next();
        System.out.println("你的名字是：" + name);

    }

    public static void guessGame() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int ran = r.nextInt(10) + 1;
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("猜字游戏1-10");
            System.out.println("请输入一个数字匹配,答案是:" + ran);
            int d = sc.nextInt();
            // isTrue = d == ran ? false : true;
            isTrue = d != ran;

        }
    }

    public static void arrayDemo() {
        double[] scores = new double[]{99.5, 88.0, 75.5};
        String[] names = new String[]{"老王", "小付"};
        // 简化写法
        int[] ages = {12, 23, 34, 45};
        //动态初始化数组
        int[] d = new int[5];
        d[0] = 10;
        d[1] = 30;
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum = +ages[i];
        }
        System.out.println(sum / ages.length);
    }

    public static void strCheck() {
        String okName = "sin8";
        String okPassword = "666";
        Scanner sc = new Scanner(System.in);
        System.out.println("登录名");
        String name = sc.next();
        System.out.println("密码");
        String Password = sc.next();
        //==只能用来比较数值，会直接比较会两个的地址
        if (okName.equals(name) && okPassword.equals(Password)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }

    public static void codeCheck() {
        String chars = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(chars.length());
            code += chars.charAt(index);
        }
        System.out.println("验证码：" + code);
    }
    public void block(){
        System.out.println("这是一个实例方法，需要创建对象后调用");
        System.out.println("静态方法可以不用创建对象调用，但是对象也可以调用静态方法但是不推荐");
    }
}
