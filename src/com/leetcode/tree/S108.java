package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-03-31 07:39
 * @Description:
 */
public class S108 {
    public TreeNode sortedArrayToBST1(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        for(int i = mid-1; i >= 0; i--){
            TreeNode node = new TreeNode(nums[i]);
            add(root, node);
        }
        for(int j = mid +1; j < nums.length; j++){
            TreeNode node = new TreeNode(nums[j]);
            add(root, node);
        }
        return root;
    }

    public void add(TreeNode root, TreeNode node){
        //ÓÒ±ß
        if(root.val < node.val){
            if(root.right == null){
                root.right = node;
            }else {
                add(root.right, node);
            }
        }

        // ×ó±ß
        if(root.val >= node.val){
            if(root.left == null){
                root.left = node;
            }else {
                add(root.left, node);
            }
        }

    }

    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) ++p;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }



    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        S108 s = new S108();
        TreeNode node = s.sortedArrayToBST(arr);
        System.out.println(node);
    }
}
