package com.leetcode.linklist;

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


    ListNode successor = null; // 后驱节点

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
     * @param head
     * @param n
     * @return
     */
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
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
    public ListNode reverseBetweenIteration(ListNode head, int m, int n) {
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
