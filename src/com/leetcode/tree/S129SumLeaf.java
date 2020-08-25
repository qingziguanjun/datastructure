package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author songyi
 * @date 2020-04-08 08:49
 * @Description:
 */
public class S129SumLeaf {

    public static void main(String[] args) {
        TreeNode node = BSTreeUtil.createTree();
        S129SumLeaf s = new S129SumLeaf();
        int sum = s.sumNumbers2(node);
        System.out.println(sum);
    }


    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }


    static int sum;
    public int sumNumbers1(TreeNode root) {
        sum = 0;
        childSum(0, root);
        return sum;
    }
    public static void  childSum(int val, TreeNode root) {
        if(root == null) return;
        int k = (val * 10 + root.val) ;
        if(root.left == null && root.right == null) {
            sum += k;
        }
        childSum(k, root.left);
        childSum(k, root.right);
    }


    //BFS±éÀú
    private List<List<Integer>> result= new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, new ArrayList<>());
        int sum = 0;
        for(List<Integer> oneList : result){
            StringBuilder sb = new StringBuilder();
            for(int i =0; i <  oneList.size() ;  i++){
                sb.append(oneList.get(i));
            }
            sum += Integer.parseInt(sb.toString());
        }
        return  sum;
    }

    public  void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        List<Integer> onePath = new ArrayList<>(list);
        onePath.add(root.val);
        //Ò¶×Ó
        if(root.left == null && root.right == null){
            result.add(onePath);
        }
        if(root.left != null){
            helper(root.left , onePath);
        }

        if(root.right != null){
            helper(root.right, onePath);
        }
    }
}
