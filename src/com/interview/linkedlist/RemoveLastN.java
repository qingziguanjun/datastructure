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
     * 笨方法
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
     * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 n+1 步，
     * 而第二个指针将从列表的开头出发。现在，这两个指针被 n个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，
     * 直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 nn 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
