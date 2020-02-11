package com.interview.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * 单链表反转
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author songyi
 * @date 2020-01-21 10:29
 * @Description:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        ReverseSingleLinkedList r = new ReverseSingleLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedListUtil.printLinkedList(node1);
        //ListNode head = r.reverseByRecursive(node1);
        ListNode head = r.reverseByIteration(node1);
        LinkedListUtil.printLinkedList(head);

    }

    /**
     * 解析递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 递归反转
     * 这个后面遍历反转太low
     * @param head
     * @return
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseByRecursive(ListNode head){
        if(head == null){
            return null;
        }
        ListNode result = head;
        if(head.next != null) {
            result = reverseByRecursive(head.next);
            head.next = null;
            ListNode next = result;
            while (next.next != null){
                next = next.next;
            }
            next.next = head;
        }
        return result;
    }

    /**
     * 迭代反转
     * @param head
     * @return
     */
    public ListNode reverseByIteration(ListNode head){
        if(head == null) return null;
        ListNode pre = null;
        ListNode next = null;
        while (head.next != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}
