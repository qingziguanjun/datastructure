package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-04-08 14:53
 * @Description:
 */
public class S22CountNum {
    public int countNodes(TreeNode root) {
        int num = 0;
        if(root == null) return 0;
        num = countNodes(root.left) + countNodes(root.right);
        return num+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        //node3.right = node7;
        S22CountNum s22CountNum = new S22CountNum();
        int i = s22CountNum.countNodes(node1);
        System.out.println(i);
    }
}
