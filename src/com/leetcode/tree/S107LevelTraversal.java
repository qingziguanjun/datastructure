package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author songyi
 * @date 2020-03-28 21:10
 * @Description:https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class S107LevelTraversal {
    /**
     * 用一个queue，每次遍历就是一层的数据，然后把这一层数据的每个节点的左右子节点都放进去
     * result.addFirst 每次把遍历的这一层放到头，就是从底部遍历，改成 add就是从上往下
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.add(oneLevel);
        }
        return result;
    }

    /**
     * 用一个queue，每次遍历就是一层的数据，然后把这一层数据的每个节点的左右子节点都放进去
     * result.addFirst 每次把遍历的这一层放到头，就是从底部遍历，改成 add就是从上往下
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> oneLevel = new LinkedList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if(level % 2 == 0) {
                    oneLevel.add(node.val);
                }else {
                    oneLevel.addFirst(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
            // 每次都往队头塞
            result.add(oneLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        S107LevelTraversal s = new S107LevelTraversal();
        TreeNode tree = BSTreeUtil.createTree();
        List<List<Integer>> lists = s.levelOrderBottom(tree);
        List<List<Integer>> lists1 = s.zigzagLevelOrder(tree);
        System.out.println(lists);
        System.out.println(lists1);
    }
}
