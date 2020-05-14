package com.sy.study.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author songyi
 * @date 2020-05-14 17:54
 * @Description:
 */
public class TestCacheInvalid {

    public static  final int  MAX_THREAD = 100;
    public static void main(String[] args) {
        MaxReqCacheInvalid maxReqCacheInvalid = new MaxReqCacheInvalid();
        CountDownLatch latch = new CountDownLatch(1);
        for(int i = 0; i < MAX_THREAD; i ++) {
            Thread t = new Thread(new Worker(latch, maxReqCacheInvalid));
            t.start();

        }
        latch.countDown();
    }


}

class Worker implements Runnable {
    MaxReqCacheInvalid maxReqCacheInvalid;
    CountDownLatch latch ;

    public Worker(CountDownLatch latch, MaxReqCacheInvalid maxReqCacheInvalid) {
        this.latch = latch;
        this.maxReqCacheInvalid = maxReqCacheInvalid;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo ÐÞ¸Ä²âÊÔ
        //System.out.println(System.currentTimeMillis());
        //maxReqCacheInvalid.badLoadShop(1);
        maxReqCacheInvalid.loadShop(1);
    }
}
