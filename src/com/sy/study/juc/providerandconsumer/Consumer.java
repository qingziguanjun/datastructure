package com.sy.study.juc.providerandconsumer;


public class Consumer implements Runnable{
    private Storage1 storage;

    public Consumer(){}

    public Consumer(Storage1 storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(3000);
                storage.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}