package com.sy.study.juc.providerandconsumer.byself;

/**
 * @author songyi
 * @date 2021-02-04 14:35
 * @Description:
 */
public class SyConsumer implements Runnable{
    private SyStorage syStorage;

    public SyConsumer(SyStorage syStorage) {
        this.syStorage = syStorage;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            syStorage.consumer();
        }
    }
}
