package com.sy.study.juc.providerandconsumer;

import java.util.LinkedList;

public class Storage1 {

    // �ֿ�����
    private final int MAX_SIZE = 10;
    // �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<>();

    public void produce() {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("��������" + Thread.currentThread().getName()
		                + "���ֿ�����");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + list.size());
            list.notifyAll();
        }
    }

    public void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("��������" + Thread.currentThread().getName() 
						+ "���ֿ�Ϊ��");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + list.size());
            list.notifyAll();
        }
    }
}