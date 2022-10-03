package com.javaSElearn;

//创建多线程

//定义一个线程类继承Thread类


public class ThreadDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程执行输出:" + i);
        }
    }
}

//实现runnable接口

class MyThreadDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("子线程方式2执行输出：" + i);
        }
    }
}

class testDemo {
    public static void main(String[] args) {
        //创建线程对象
        ThreadDemo r = new ThreadDemo();
        r.start();
        //创建任务对象
        Runnable m = new MyThreadDemo();
        Thread t = new Thread(m);
        t.start();

        //简化写法

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("简化写法线程输出:" + i);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("简化写法线程2输出:" + i);
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行输出:" + i);
        }
    }

}