package com.leetcode.linklist;

/**
 * @author songyi
 * @date 2020-07-30 10:05
 * @Description:
 */
public class S141HasCircle {
        public boolean hasCycleWrong(ListNode head) {

            ListNode slow = head, fast = head;
            while (slow != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }

            return false;
        }


    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }

        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public boolean hasCircle(ListNode head){
        if(head == null && head.next == null ) return false;
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == null || fast == null){
                return false;
            }
        }
        return true;
    }

















}
