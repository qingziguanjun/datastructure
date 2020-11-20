package com.leetcode.tree;

import java.util.*;

/**
  @author songyi
  @date 2020-04-02 13:09
  @Description:
 */

public class S112PathSum1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == sum) {
                return true;
            }else {
                return false;
            }
        }
        int value = sum - root.val;
        return hasPathSum(root.left, value) || hasPathSum(root.right, value);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        helper(root, sum, list);
        System.out.println(result);
        return result;
    }

    public void helper(TreeNode root, int sum, List<Integer> list){
        if(root == null) return ;
        if(root.left == null && root.right == null){
            if(root.val == sum) {
                List<Integer> list2 = new ArrayList<>();
                list2.addAll(list);
                list2.add(root.val);
                result.add(list2);
            }else {
                return ;
            }
        }
        list.add(root.val);
        int value = sum - root.val;
        helper(root.left, value, list);
        helper(root.right, value, list);
        list.remove(list.size()-1);

    }



    /**
     *  https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }


    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */


    public boolean hasPathSumSelfRecur(TreeNode root, int sum) {
        if(root == null ){return  false;}
        if(root.left == null && root.right == null){
            //叶子节点
            if(root.val == sum){
                return true;
            }
        }
        int value = sum - root.val;
        return hasPathSumSelfRecur(root.left, value) || hasPathSumSelfRecur(root.right, value);
    }

    public boolean hasPathSumSelfIter(TreeNode root, int sum) {
        if(root == null ){return  false;}
        if(root.left == null && root.right == null){
            //叶子节点
            if(root.val == sum){
                return true;
            }
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        nodeStack.add(root);
        valueStack.add(sum);
        while (!nodeStack.isEmpty()){
            TreeNode treeNode = nodeStack.pop();
            Integer pop = valueStack.pop();
            if(treeNode.left == null && treeNode.right == null){
                //叶子节点
                if(pop == treeNode.val){
                    return true;
                }
            }
            if(treeNode.left != null){
                nodeStack.add(treeNode.left);
                valueStack.add(pop - treeNode.val);
            }
            if(treeNode.right != null){
                nodeStack.add(treeNode.right);
                valueStack.add(pop - treeNode.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S112PathSum1 s = new S112PathSum1();
        TreeNode tree = BSTreeUtil.createTree();
        boolean result = s.hasPathSum(tree, 4);
        System.out.println(result);
        result = s.hasPathSum(tree, 18);
        System.out.println(result);
        boolean b = s.hasPathSumSelfRecur(tree, 18);
        System.out.println(b);
        boolean c = s.hasPathSumSelfIter(tree, 18);
        System.out.println(c);
        //s.pathSum(tree, 18);
    }

















}
