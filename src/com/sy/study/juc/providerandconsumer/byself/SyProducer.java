package com.sy.study.juc.providerandconsumer.byself;

/**
 * @author songyi
 * @date 2021-02-04 14:35
 * @Description:
 */
public class SyProducer implements Runnable{
    private SyStorage syStorage;

    public SyProducer(SyStorage syStorage) {
        this.syStorage = syStorage;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            syStorage.produce();
        }
    }
}
