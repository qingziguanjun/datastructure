package com.train1112.tree;



import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-03-02 08:16
 * @Description:
 */
public class BSTreeUtil {
    public static TreeNode createTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node6;
        node2.right = node7;
        node3.left = node4;
        node3.right = node5;
        node7.left = node8;
        return node1;
    }

    /**
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }

    public static void printTree(TreeNode root){
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }
}
