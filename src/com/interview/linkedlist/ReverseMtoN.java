package com.interview.linkedlist;

/**
 * @author songyi
 * @date 2020-01-21 11:30
 * @Description:
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseMtoN {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseMtoN r = new ReverseMtoN();
        ListNode head = r.reverseBetween(node1, 2, 4);
        LinkedListUtil.printLinkedList(head);

    }
    /**
     *
     * 1 ≤ m ≤ n ≤ 链表长度。
     * @param head
     * @param m
     * @param n
     * @return
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //todo 3 5 m=1 n = 2
        ListNode start = head;
        ListNode begin = head;
        for(int i = 1; i < m ; i++){
            start = begin;
            begin = begin.next;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode last = begin;
        for(int i = m; i <= n; i++){
            next = last.next;
            last.next = pre;
            pre = last;
            last = next;

        }
        //1->2<-3<-4->5
        start.next = pre;
        begin.next = next;

        return head;
    }
}
