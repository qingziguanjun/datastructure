package com.sy.study.juc;

import com.algs4.algs4.Count;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

//获得线程的返回结果方式一
/*
 *在runnable实现类中设置一个变量x,在run方法中将其改变为我们期待的结果，然后通过一个getX()方法将这个变量返回
 */
public class RunnableTestCountDown {


    public static void main(String[] args) throws Exception {
        System.out.println("使用Runnable获取返回结果");
        long start = System.currentTimeMillis();
        List<RunnableAcction> tasks = new ArrayList<>(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        //创建10个线程，每个线程分别负责累加1-10,11-20，.........，91-100
        for (int i = 0; i < 10; i++) {
            RunnableAcction task = new RunnableAcction(i * 10 + 1, (i + 1) * 10, countDownLatch);
            Thread work = new Thread(task, "累加器线程" + i);
            tasks.add(task);
            work.start();
        }

        countDownLatch.await();
        int total = 0;
        for (int i = 0; i < tasks.size(); i++) {
            //System.out.println(workers.get(i).getName() + "##################");
            total += tasks.get(i).getResult();
        }
        System.out.println("\n累加的结果：" + total);
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
    }


    static final class RunnableAcction implements Runnable {

        private int a;
        private CountDownLatch countDownLatch;

        public RunnableAcction(int a, int b, CountDownLatch countDownLatch) {
            super();
            this.a = a;
            this.b = b;
            this.countDownLatch = countDownLatch;
        }

        private int b;
        private int result;

        @Override
        public void run() {
            int num =  (a-1) /10;
            long start = System.currentTimeMillis();
            System.out.printf("(%s) - 开始运行", Thread.currentThread().getName());
            System.out.println();
            result = 0;
            try {
                for (int i = a; i <= b; i++) {
                    result += i;
                    if(num == 5) {
                        Thread.sleep(10 * (10 + num));
                    }else {
                        Thread.sleep(10 * (10 - num));
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            System.out.printf("(%s) - 运行结束，结果为 %d\n", Thread.currentThread().getName(), result);
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "用时：" + (end - start) + "ms");
            countDownLatch.countDown();
        }

        public int getResult() {//获取线程返回结果
            return result;
        }
    }
}