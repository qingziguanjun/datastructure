package com.sy.study.juc;

import java.util.*;
import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws Exception {
        System.out.println("ʹ�� Callable ��÷��ؽ����");

        List<FutureTask<Integer>> futureTasks = new ArrayList<>(10);
        // �½� 10 ���̣߳�ÿ���̷ֱ߳����ۼ� 1~10, 11~20, ..., 91~100
        for (int i = 0; i < 10; i++) {
            AccumCallable task = new AccumCallable(i * 10 + 1, (i + 1) * 10);
            FutureTask<Integer> futureTask = new FutureTask<>(task);
            futureTasks.add(futureTask);
            Thread worker = new Thread(futureTask, "�����ۼ����߳�" + i);
            worker.start();
        }

        int total = 0;
        for (FutureTask<Integer> futureTask : futureTasks) {
            total += futureTask.get(); // get() ����������ֱ����ý��
        }
        System.out.println("�ۼӵĽ��: " + total);
    }

    static final class AccumCallable implements Callable<Integer> {

        private final int begin;
        private final int end;

        public AccumCallable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int result = 0;
            for (int i = begin; i <= end; i++) {
                result += i;
                Thread.sleep(100);
            }
            System.out.printf("(%s) - ���н��������Ϊ %d\n",
                    Thread.currentThread().getName(), result);
            return result;
        }
    }
}

