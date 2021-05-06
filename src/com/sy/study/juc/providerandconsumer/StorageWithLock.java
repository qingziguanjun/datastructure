package com.sy.study.juc.providerandconsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StorageWithLock {

    // �ֿ����洢��
    private final int MAX_SIZE = 10;
    // �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<Object>();
    // ��
    private final Lock lock = new ReentrantLock();
    // �ֿ�������������
    private final Condition full = lock.newCondition();
    // �ֿ�յ���������
    private final Condition empty = lock.newCondition();

    public void produce()
    {
        // �����
        lock.lock();
        while (list.size() + 1 > MAX_SIZE) {
            System.out.println("��������" + Thread.currentThread().getName()
		             + "���ֿ�����");
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        System.out.println("��������" + Thread.currentThread().getName() 
				 + "������һ����Ʒ���ֿ��" + list.size());

        empty.signalAll();
        lock.unlock();
    }

    public void consume()
    {
        // �����
        lock.lock();
        while (list.size() == 0) {
            System.out.println("��������" + Thread.currentThread().getName()
		             + "���ֿ�Ϊ��");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove();
        System.out.println("��������" + Thread.currentThread().getName()
		         + "������һ����Ʒ���ֿ��" + list.size());

        full.signalAll();
        lock.unlock();
    }
}