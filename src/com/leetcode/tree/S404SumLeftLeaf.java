package com.leetcode.tree;

import com.leetcode.util.Array2BinTree;

/**
 * @author songyi
 * @date 2020-04-17 07:39
 * @Description:
 */
public class S404SumLeftLeaf {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null ){
            if(root.left.left == null && root.left.right == null){
                sum +=  root.left.val;
            }else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if(root.right != null) {
            if(root.right.left != null || root.right.right != null){
                sum += sumOfLeftLeaves(root.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
       // int[] array = {0,2,4,1,Integer.MIN_VALUE,3,-1,5,1,Integer.MIN_VALUE,6,Integer.MIN_VALUE,8};
        int[] array = {0,-4,-3,Integer.MIN_VALUE,-1,8,Integer.MIN_VALUE,Integer.MIN_VALUE,3,Integer.MIN_VALUE,-9,-2,Integer.MIN_VALUE,4};
        TreeNode node = Array2BinTree.array2BinTree(array);
        S404SumLeftLeaf s = new S404SumLeftLeaf();
        int sum = s.sumOfLeftLeaves(node);
        System.out.println(sum);

    }


}
