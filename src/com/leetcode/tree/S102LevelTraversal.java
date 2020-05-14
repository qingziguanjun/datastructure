package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
