package com.train20210423.linklist;

import com.leetcode.linklist.ListNode;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @author songyi
 * @date 2021-04-23 10:23
 * @Description:
 */
public class LinkListOperate {

    public static Node geneLinkList(int[] nums){
        int length = nums.length - 1;
        Node next = null;
        for(int i = length; i >= 0 ;i--){
            Node node = new Node(nums[i]);
            node.next = next;
            next = node;
        }
        return next;
    }

    public static  void printNode(Node head){
        if(head == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null){
            sb.append(temp.value).append("   ");
            temp = temp.next;
        }
        System.out.println(sb.toString());
    }
    //1.1 链表反转  非递归
    public Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node head = null;
        Node next = null;
        while (node != null){
            next = node.next;
            node.next = head;
            head = node;
            node = next;
        }
        return head;
    }

    /**
     *         Node pre = null;
     *         Node next = null;
     *         Node head1 = begin;
     *         for(int i = m; i <= n; i++){
     *             next = head1.next;
     *             head1.next = pre;
     *             pre = head1;
     *             head1 = next;
     *         }
     *
     * @param node
     * @return
     */
    //1.2 链表反转  递归
    public Node reverseIterate(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node next = node.next;
        Node node1 = reverseIterate(next);
        next.next = node;
        //todo 下面这句话不能漏了，不然那就成环了
        node.next = null;
        return node1;

    }

    /**
     * 解析递归
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //2.链表是否有环
    //3.两个有序链表合并
    //4. 反转链表 (m，n)
    public Node reverseM2N(Node head, int m, int n){
        Node begin = head;
        Node start = head;
        for(int i = 1; i < m; i++){
            start = begin;
            begin = begin.next;

        }
        //从
        Node pre = null;
        Node next = null;
        Node head1 = begin;
        for(int i = m; i <= n; i++){
            next = head1.next;
            head1.next = pre;
            pre = head1;
            head1 = next;
        }
        //上面循环把m-n 处理后，2 的next是null，此时begin就是2 ，start 是1
        //pre 变成了4 next 是 5
        //最后把1 4 连一起， 2 5 连一起
        start.next = pre;
        begin.next = next;
        //next.next
        return head;
    }

    public Node reverseBetweenIteration(Node head, int m, int n) {
        //todo 3 5 m=1 n = 2
        Node start = head;
        Node begin = head;
        for(int i = 1; i < m ; i++){
            start = begin;
            begin = begin.next;
        }
        Node pre = null;
        Node next = null;
        Node last = begin;
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
    //5.
    //6.
}

class Node{
    int value;
    Node next;
    Node(int x){
        this.value = x;
    }
}
