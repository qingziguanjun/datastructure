package com.sy.study.juc.providerandconsumer;

public class Producer implements Runnable{
    private Storage1 storage;

    public Producer(){}

    public Producer(Storage1 storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                storage.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}