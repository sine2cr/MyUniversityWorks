package com.javaSElearn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        //创建callable任务对象
        Callable<String> call = new MyCallable(100);
        //把callable任务对象交给future对象
        //future对象的作用 是runnable的对象 可以交给Threa
        //作用2 可以在线程执行完毕后通过调用其get方法得到线程执行完成的结果
        FutureTask<String> f1 = new FutureTask<>(call);
        //交给线程处理
        Thread t1 = new Thread(f1);
        //开启线程
        t1.start();


        try {
            System.out.println(f1.get());

        } catch (Exception e) {
            e.printStackTrace();
        }


        Thread test1 = new TestThread();
        test1.setName("一号测试线程名");
        test1.start();
        Thread test2 = new TestThread();
        test2.setName("二号测试线程名");
        test2.start();
        //拿到当前执行他的线程对象
        Thread m = Thread.currentThread();
        System.out.println(m.getName());
    }


}

/*
 * 定义一个任务类 实现callable接口 申明线程任务执行完毕后的结果的数据类型
 */
class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("线程执行了");
        return "子线程执行的结果:" + sum;

    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("子线程api方法测试" + i);
            System.out.println("当前执行的线程:" + Thread.currentThread().getName());
        }
    }
}