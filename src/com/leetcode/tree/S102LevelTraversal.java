package com.leetcode.tree;

import java.util.*;

/**
 * @author songyi
 * @date 2020-03-28 21:10
 * @Description:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class S102LevelTraversal {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        List<List<Integer>> list = helper(root, 0);
        return list;
    }

    public List<List<Integer>>  helper(TreeNode treeNode, int level){
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(treeNode.val);

        if (treeNode.left != null) {
            helper(treeNode.left, level + 1);
        }
        if (treeNode.right != null) {
            helper(treeNode.right, level + 1);
        }
        return levels;
    }

    public static void main(String[] args) {
        S102LevelTraversal s = new S102LevelTraversal();
        TreeNode tree = BSTreeUtil.createTree();
        List<List<Integer>> lists = s.levelOrder(tree);
        System.out.println(lists);
    }


    /**
     * Á´½Ó£ºhttps://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     * @param root
     */
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java µÄ pop Ð´×÷ poll()
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public List<List<Integer>>  levelOrderBFS(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderSelf(TreeNode root) {
        if(root == null) return res;
        helper(root, 0);
        return res;
    }

    public void helper1(TreeNode treeNode, int n){
        if(res.size() == n){
            res.add(new ArrayList<>());
        }
        List<Integer> integers = res.get(n);
        integers.add(treeNode.val);
        if(treeNode.left != null){
            helper1(treeNode.left, n+1);
        }

        if(treeNode.right != null){
            helper1(treeNode.right, n+1);
        }
    }








































}
