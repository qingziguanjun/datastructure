package com.sy.study.juc.providerandconsumer;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class StorageWithSemaphore {

    // �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<Object>();
	// �ֿ���������
    final Semaphore notFull = new Semaphore(10);
    // ���̹߳��𣬵ȴ�����������
    final Semaphore notEmpty = new Semaphore(0);
    // ������
    final Semaphore mutex = new Semaphore(1);

    public void produce()
    {
        try {
            notFull.acquire();
            mutex.acquire();
            list.add(new Object());
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + list.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    public void consume()
    {
        try {
            notEmpty.acquire();
            mutex.acquire();
            list.remove();
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}