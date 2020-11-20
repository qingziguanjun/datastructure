package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-04-02 10:12
 * @Description:
 */
public class S111MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
        return max;
    }


    // 这样是错误的
    public int minDepthWrong(TreeNode root) {
        if(root == null){
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int min = Math.min(minDepthWrong(root.left), minDepthWrong(root.right)) +1;
        return min;
    }
}
