package com.leetcode.tree;

import java.util.HashMap;

/**
 * @author songyi
 * @date 2020-04-01 10:43
 * @Description:
 */
public class S105106 {
    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left == in_right)
            return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val);

        // recursion
        pre_idx++;
        // build left subtree
        root.left = helper(in_left, index );
        // build right subtree
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }

    public static void main(String[] args) {
        int[] preorder = {4,3,5,10,8,6,9};
        int[] inorder = {5,3,10,4,6,8,9};
        int[] postorder = {5,10,3,6,9,8,4};
        S105106 s105106 = new S105106();
        TreeNode node = s105106.buildTree(preorder, inorder);
        BSTreeUtil.printTree(node);
    }

}
