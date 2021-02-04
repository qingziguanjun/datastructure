package com.sy.study.juc;

import com.algs4.algs4.Count;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

//����̵߳ķ��ؽ����ʽһ
/*
 *��runnableʵ����������һ������x,��run�����н���ı�Ϊ�����ڴ��Ľ����Ȼ��ͨ��һ��getX()�����������������
 */
public class RunnableTestCountDown {


    public static void main(String[] args) throws Exception {
        System.out.println("ʹ��Runnable��ȡ���ؽ��");
        long start = System.currentTimeMillis();
        List<RunnableAcction> tasks = new ArrayList<>(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        //����10���̣߳�ÿ���̷ֱ߳����ۼ�1-10,11-20��.........��91-100
        for (int i = 0; i < 10; i++) {
            RunnableAcction task = new RunnableAcction(i * 10 + 1, (i + 1) * 10, countDownLatch);
            Thread work = new Thread(task, "�ۼ����߳�" + i);
            tasks.add(task);
            work.start();
        }

        countDownLatch.await();
        int total = 0;
        for (int i = 0; i < tasks.size(); i++) {
            //System.out.println(workers.get(i).getName() + "##################");
            total += tasks.get(i).getResult();
        }
        System.out.println("\n�ۼӵĽ����" + total);
        long end = System.currentTimeMillis();
        System.out.println("��ʱ��" + (end - start));
    }


    static final class RunnableAcction implements Runnable {

        private int a;
        private CountDownLatch countDownLatch;

        public RunnableAcction(int a, int b, CountDownLatch countDownLatch) {
            super();
            this.a = a;
            this.b = b;
            this.countDownLatch = countDownLatch;
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
            countDownLatch.countDown();
        }

        public int getResult() {//��ȡ�̷߳��ؽ��
            return result;
        }
    }
}