package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-04-08 15:27
 * @Description:https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class S199RightSideView {

    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return list;
    }
    public void helper(TreeNode root, int n) {
        if (root == null) return;
        if (n == list.size()) list.add(root.val);
        helper(root.right, n + 1);
        helper(root.left, n + 1);
    }
    public static void main(String[] args) {
        S199RightSideView s = new S199RightSideView();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        //node3.right = node7;
        List<Integer> integers = s.rightSideView(node1);
        System.out.println(integers);
    }


}

