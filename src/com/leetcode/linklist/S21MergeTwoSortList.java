package com.leetcode.linklist;

/**
 * @author songyi
 * @date 2020-01-30 11:07
 * @Description:
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class S21MergeTwoSortList {
    //todo 没有完成
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1.val <= l2.val){
            head = l1;
        }else {
            head = l2;
        }
        while (l1 != null && l2 != null){
            //if()
        }
        return head;
    }
}
