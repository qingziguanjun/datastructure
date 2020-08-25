package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-04-08 14:34
 * @Description:
 *
 */
public class S226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = invertTree(root.left);;
        root.left = invertTree(root.right);;
        root.right = temp;

        return root;
    }

    public static void main(String[] args) {
        S226InvertTree s = new S226InvertTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        TreeNode node = s.invertTree(node1);
        BSTreeUtil.printTree(node);

    }


    public TreeNode invertTree1(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
