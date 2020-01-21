package com.sy.study.queue;

/**
 * @author songyi
 * @date 2020-01-19 07:21
 * @Description:
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//对列头
        rear = -1;//队列尾
    }

    public boolean isFull(){
        return rear == maxSize -1;
    }

    public boolean isEmpty(){
        //从-1开始的
        return front == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("满了");
            return;
        }
        rear++;
        arr[rear] = n;

    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("empty");
        }
        return arr[++front];
    }

}
