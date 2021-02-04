package com.sy.study.juc.threadtest;

import java.util.concurrent.Callable;

/**
 * @author songyi
 * @date 2021-01-30 11:45
 * @Description:
 */
public class ThreadTest {
    static  Object lock = new Object();
    public static void main(String[] args) {
//        Worker worker1 = new Worker();
//        Worker worker2 = new Worker();
//        new Thread(worker1).start();
//        new Thread(worker2).start();

        WorkerWait workerWait = new WorkerWait();
        WorkerNotify workerNotify = new WorkerNotify();
        new Thread(workerWait).start();
        new Thread(workerNotify).start();
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "获得锁");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        }
    }


    static class WorkerWait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "获得锁");

                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "继续执行");
                    Thread.sleep(1000);
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getName() + "结束");
            }
        }
    }

    static class WorkerNotify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "获得锁");
                try {

                    Thread.sleep(1000);
                    lock.notify();
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getName() + "结束");
            }
        }
    }


}
