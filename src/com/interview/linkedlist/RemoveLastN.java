package com.interview.linkedlist;

import java.util.List;

/**
 * @author songyi
 * @date 2020-01-30 10:37
 * @Description:https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 */
public class RemoveLastN {
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
        ListNode head = new RemoveLastN().removeNthFromEnd(node1, 2);
        LinkedListUtil.printLinkedList(head);
    }

    /**
     * ������
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int num = 0;
        ListNode temp = head;
        while (temp != null){
            num++;
            temp = temp.next;
        }
        int index = 0;
        temp = head;
        if(num == n){
            return head.next;
        }
        while (temp.next != null){
            index++;
            if(index == num -n){
                temp.next = temp.next.next;
                break;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
    /**
     * �����㷨�����Ż�Ϊֻʹ��һ�α��������ǿ���ʹ������ָ�������һ��ָ�롣��һ��ָ����б�Ŀ�ͷ��ǰ�ƶ� n+1 n+1 ����
     * ���ڶ���ָ�뽫���б�Ŀ�ͷ���������ڣ�������ָ�뱻 n�����ֿ�������ͨ��ͬʱ�ƶ�����ָ����ǰ����������㶨�ļ����
     * ֱ����һ��ָ�뵽�����һ����㡣��ʱ�ڶ���ָ�뽫ָ������һ���������ĵ� nn ����㡣
     * �����������ӵڶ���ָ�������õĽ��� next ָ��ָ��ý������¸���㡣
     *
     * ���ߣ�LeetCode
     * ���ӣ�https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     *     ListNode dummy = new ListNode(0);
     *     dummy.next = head;
     *     ListNode first = dummy;
     *     ListNode second = dummy;
     *     // Advances first pointer so that the gap between first and second is n nodes apart
     *     for (int i = 1; i <= n + 1; i++) {
     *         first = first.next;
     *     }
     *     // Move first to the end, maintaining the gap
     *     while (first != null) {
     *         first = first.next;
     *         second = second.next;
     *     }
     *     second.next = second.next.next;
     *     return dummy.next;
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 1; i < n+1 ; i++){
            p2 = p2.next;
        }
        if(p2 == null){
            return head.next;
        }
        while (p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }


}
