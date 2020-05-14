package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-04-10 08:45
 * @Description:
 */
public class S235CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if(root.val <= max && root.val >= min){
            return root;
        }

        if(root.val < min){
            return lowestCommonAncestor(root.right, p, q);
        }

        if(root.val > max){
            return lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        S235CommonAncestor s = new S235CommonAncestor();
        TreeNode ancestor1 = s.lowestCommonAncestor(node1,node2, node3 );
        TreeNode ancestor2 = s.lowestCommonAncestor(node1,node2, node5 );
        System.out.println(ancestor1.val);
        System.out.println(ancestor2.val);

    }
}
