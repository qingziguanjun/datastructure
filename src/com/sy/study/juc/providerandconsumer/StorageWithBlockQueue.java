package com.sy.study.juc.providerandconsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class StorageWithBlockQueue {

    // �ֿ�洢������
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(10);

    public void produce() {
        try{
            list.put(new Object());
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consume() {
        try{
            list.take();
            System.out.println("��������" + Thread.currentThread().getName()
                    + "��������һ����Ʒ���ֿ��" + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}