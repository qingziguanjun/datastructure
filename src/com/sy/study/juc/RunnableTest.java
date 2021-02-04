package com.sy.study.juc;

import java.util.*;

import sun.swing.AccumulativeRunnable;

//����̵߳ķ��ؽ����ʽһ
/*
 *��runnableʵ����������һ������x,��run�����н���ı�Ϊ�����ڴ��Ľ����Ȼ��ͨ��һ��getX()�����������������
 */
public class RunnableTest {


    public static void main(String[] args) throws Exception {
        System.out.println("ʹ��Runnable��ȡ���ؽ��");
        long start = System.currentTimeMillis();
        List<Thread> workers = new ArrayList<>(10);
        List<RunnableAcction> tasks = new ArrayList<>(10);
        //����10���̣߳�ÿ���̷ֱ߳����ۼ�1-10,11-20��.........��91-100
        for (int i = 0; i < 10; i++) {
            RunnableAcction task = new RunnableAcction(i * 10 + 1, (i + 1) * 10);
            Thread work = new Thread(task, "�ۼ����߳�" + i);
            workers.add(work);
            tasks.add(task);
            work.start();
        }
        long end = System.currentTimeMillis();
        System.out.println("��ʱ1��" + (end - start));

        int total = 0;
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).join();
            System.out.println(workers.get(i).getName() + "##################");
            total += tasks.get(i).getResult();
        }
        System.out.println("\n�ۼӵĽ����" + total);
        end = System.currentTimeMillis();
        System.out.println("��ʱ��" + (end - start));
    }


    static final class RunnableAcction implements Runnable {

        private int a;

        public RunnableAcction(int a, int b) {
            super();
            this.a = a;
            this.b = b;
        }

        private int b;
        private int result;

        @Override
        public void run() {
            int num =  (a-1) /10;
            long start = System.currentTimeMillis();
            System.out.printf("(%s) - ��ʼ����", Thread.currentThread().getName());
            System.out.println();
            result = 0;
            try {
                for (int i = a; i <= b; i++) {
                    result += i;
                 if(num == 5) {
                  Thread.sleep(10 * (10 + num));
                 }else {
                  Thread.sleep(10 * (10 - num));
                 }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.printf("(%s) - ���н��������Ϊ %d\n", Thread.currentThread().getName(), result);
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "��ʱ��" + (end - start) + "ms");
        }

        public int getResult() {//��ȡ�̷߳��ؽ��
            return result;
        }
    }
}