package com.leetcode.tree;

import java.util.*;

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


    /**
     *  ���ߣ�LeetCode-Solution
     *     ���ӣ�https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
     *     ��Դ�����ۣ�LeetCode��
     *     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param root
     * @return
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // ά����������������
                max_depth = Math.max(max_depth, depth);

                // ��������ڶ�Ӧ��ȵĽڵ����ǲŲ���
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


    public List<Integer> rightSideViewBFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                // ά����������������
                max_depth = Math.max(max_depth, depth);

                // ����ÿһ�����һ�����ʵ��Ľڵ��������Ҫ�Ĵ𰸣���˲��ϸ��¶�Ӧ��ȵ���Ϣ����
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
















}

