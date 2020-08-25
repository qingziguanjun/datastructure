package com.leetcode.linklist;


import com.algs4.algs4.Heap;

/**
 * @author songyi
 * @date 2020-07-25 20:08
 * @Description:
 */
public class S206ReverseLinkList {

    /**
     * if(head == null) return null;
     *         ListNode pre = null;
     *         ListNode next = null;
     *         while (head.next != null){
     *             next = head.next;
     *             head.next = pre;
     *             pre = head;
     *             head = next;
     *         }
     *         head.next = pre;
     *         return head;
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return head;
    }


    /**
     * 1-2-3-4-5
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if(head == null || head.next ==  null) return head;
        ListNode result = null;
        if(head.next != null){
            result = reverse(head.next);
        }
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        S206ReverseLinkList r = new S206ReverseLinkList();
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
       // ListNode head = r.reverse(node1);
        ListNode head = r.reverse(node1);
        LinkedListUtil.printLinkedList(head);

    }
}
