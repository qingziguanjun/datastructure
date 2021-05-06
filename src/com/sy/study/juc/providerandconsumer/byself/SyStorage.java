package com.sy.study.juc.providerandconsumer.byself;

import java.util.LinkedList;

/**
 * @author songyi
 * @date 2021-02-04 14:19
 * @Description:
 */
public class SyStorage {
    private LinkedList<String> storage = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public void produce() {
        synchronized (storage) {
            while (storage.size() + 1 > MAX_SIZE) {
                System.out.println(Thread.currentThread().getName() + "，仓库满了");
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add("产品" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "，生产了， 库存" + storage.size());
            storage.notifyAll();
        }
    }

    public void consumer() {
        synchronized (storage) {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "，仓库空了");
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.remove();
            System.out.println(Thread.currentThread().getName() + ",消费了");
            storage.notifyAll();

        }
    }
}
