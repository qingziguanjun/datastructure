package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-03-26 07:00
 * @Description:
 */
public class S99ValidtBts {
    /**
     *   左边树最大的 比 root小
     *   右边树最小的要比 root 大
     *
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        if(root == null){
            return true;
        }
        boolean b = validLeft(root.val, root.left);
        if(!b) return false;
        b = validRight(root.val, root.right);
        if(!b) return false;
        return true;
    }

    private boolean validLeft(int val, TreeNode root) {
        if(root == null) return true;
        if(root.val >= val) return false;

        boolean b = validLeft(root.val, root.left);
        if(!b) return false;
        b = validRight(root.val, root.right);
        if(!b) return false;
        return true;
    }

    private boolean validRight(int val, TreeNode root) {
        if(root == null) return true;
        if(root.val <= val) return false;
        boolean b = validLeft(root.val, root.left);
        if(!b) return false;
        b = validRight(root.val, root.right);
        if(!b) return false;
        return true;
    }



    public boolean helper(TreeNode node, Integer lower, Integer upper, boolean isLeft) {
        if(isLeft){
            System.out.print("比较左节点" + node);
        }else {
            System.out.print("比较右节点" + node );
        }
        System.out.println("lower= " + lower + ", upper= " + upper);

        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper, false)) return false;
        if (! helper(node.left, lower, val, true)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null, false);
    }

    public static void main(String[] args) {
        TreeNode tree = BSTreeUtil.createTree();
        new S99ValidtBts().isValidBST(tree);
    }
}
