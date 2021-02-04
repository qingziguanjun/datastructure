package com.sy.study.juc;

import java.util.*;

import sun.swing.AccumulativeRunnable;

//获得线程的返回结果方式一
/*
 *在runnable实现类中设置一个变量x,在run方法中将其改变为我们期待的结果，然后通过一个getX()方法将这个变量返回
 */
public class RunnableTest {


    public static void main(String[] args) throws Exception {
        System.out.println("使用Runnable获取返回结果");
        long start = System.currentTimeMillis();
        List<Thread> workers = new ArrayList<>(10);
        List<RunnableAcction> tasks = new ArrayList<>(10);
        //创建10个线程，每个线程分别负责累加1-10,11-20，.........，91-100
        for (int i = 0; i < 10; i++) {
            RunnableAcction task = new RunnableAcction(i * 10 + 1, (i + 1) * 10);
            Thread work = new Thread(task, "累加器线程" + i);
            workers.add(work);
            tasks.add(task);
            work.start();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时1：" + (end - start));

        int total = 0;
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).join();
            System.out.println(workers.get(i).getName() + "##################");
            total += tasks.get(i).getResult();
        }
        System.out.println("\n累加的结果：" + total);
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
    }


    static final class RunnableAcction implements Runnable {

        private int a;

        public RunnableAcction(int a, int b) {
            super();
            this.a = a;
            this.b = b;
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
        }

        public int getResult() {//获取线程返回结果
            return result;
        }
    }
}