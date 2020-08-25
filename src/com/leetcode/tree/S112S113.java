package com.leetcode.tree;

import com.interview.tree.bst.BSTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  @author songyi
  @date 2020-04-02 13:09
  @Description:
 */

public class S112S113 {
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
    public static void main(String[] args) {
        S112S113 s = new S112S113();
        TreeNode tree = BSTreeUtil.createTree();
        boolean result = s.hasPathSum(tree, 4);
        System.out.println(result);
        result = s.hasPathSum(tree, 17);
        System.out.println(result);
        result = s.hasPathSum(tree, 22);
        System.out.println(result);

        s.pathSum(tree, 22);
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
















}
