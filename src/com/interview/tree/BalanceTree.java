package com.interview.tree;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

/**
 * @author songyi
 * @date 2020-03-08 08:18
 * @Description:https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalanceTree {
    public static void main(String[] args) {
        int[] nums ={1,3,5,6};
        BalanceTree balanceTree = new BalanceTree();
        int result = 0 ;
        result = balanceTree.searchInsert(nums, 4);
        System.out.println(result);
        result = balanceTree.searchInsert(nums, 0);
        System.out.println(result);
        result = balanceTree.searchInsert(nums, 2);
        System.out.println(result);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return  Math.abs(maxDepth(root.left) -maxDepth(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLeft = 0 , maxRight = 0;
        if(root.left != null){
            maxLeft =  maxDepth(root.left);
        }
        if(root.right != null){
            maxRight = maxDepth(root.right);
        }
        if(maxRight >= maxLeft){
            return maxRight+1;
        }else {
            return maxLeft + 1;
        }
    }

    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return binarySerach(nums, 0, nums.length-1, target);

    }

    public int binarySerach(int[] nums, int left, int right, int target){
        int mid = 0;
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] < target ){
                left = mid + 1 ;
            }else if(nums[mid] > target ){
                right = mid - 1;
            }else {
               return mid;
            }
        }
        //没找到直接返回left，神奇啊，如何做到的
        return left;
    }
}
