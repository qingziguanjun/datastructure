package com.interview.tree;

/**
 * @author songyi
 * @date 2020-03-02 08:13
 * @Description: 二叉树最大深度
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree();
        MaxDepth maxDepth = new MaxDepth();
        int depth = maxDepth.maxDepth(tree);
        System.out.println(depth);
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLeft = 0 , maxRight = 0;
        if(root.left != null){
            maxLeft =  maxDepth(root.left);
        }
        if(root.right != null){
            maxRight = maxDepth(root.right);
        }
        if(maxRight >= maxLeft){
            return maxRight+1;
        }else {
            return maxLeft + 1;
        }
    }
}
