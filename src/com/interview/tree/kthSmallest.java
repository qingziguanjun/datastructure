package com.interview.tree;

/**
 * @author songyi
 * @date 2020-03-16 15:51
 * @Description:  https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
 */
public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        int size = size(root.left);
        if(size == k -1){
            return root.val;
        }else if(size < k -1 ){
            return kthSmallest(root.right, k - 1 - size);
        }else {
            return  kthSmallest(root.left, k);
        }
    }


    public int size(TreeNode root){
        if(root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }
}
