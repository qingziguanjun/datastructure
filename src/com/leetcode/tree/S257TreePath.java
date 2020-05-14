package com.leetcode.tree;

import com.interview.tree.MaxDepth;

import java.util.List;

/**
 * @author songyi
 * @date 2020-04-16 09:32
 * @Description:
 */
public class S257TreePath {

    //["1->2->5", "1->3"]
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return null;
        if(root.left != null){

        }
        if(root.right != null){

        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        int[] nums = {2,1,1,2};
        int num = rob1(nums);
        System.out.println(num);
    }

    public int rob(int[] nums) {
        int num1 = 0 , num2 = 0;
        for(int i=0; i < nums.length; i++){
            if(i % 2 == 0){
                num1 += nums[i];
            }else {
                num2 += nums[i];
            }
        }
        return Math.max(num1, num2);
    }

    public static  int rob1(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}
