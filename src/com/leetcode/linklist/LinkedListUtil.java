package com.leetcode.linklist;

/**
 * @author songyi
 * @date 2020-01-21 10:39
 * @Description:
 */
public class LinkedListUtil {
    /**
     * 打印链表
     * @param head
     */
    public static void printLinkedList(ListNode head){
        if(head == null){
            return;
        }
        System.out.println("--------------------打印开始---------------------");
        while (head != null){
            System.out.print(head.val  + "--");
            head = head.next;
        }
        System.out.println();
        System.out.println("-----------------打印结束-------------------------");
    }
}
