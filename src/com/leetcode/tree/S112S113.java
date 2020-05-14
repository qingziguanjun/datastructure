package com.leetcode.tree;

import com.interview.tree.bst.BSTree;

import java.util.ArrayList;
import java.util.List;

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
}
