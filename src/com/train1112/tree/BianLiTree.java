package com.train1112.tree;

import com.leetcode.linklist.ListNode;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author songyi
 * @date 2020-11-12 16:16
 * @Description:树的遍历
 * 前中后 * （递归 迭代）6种方式
 */
public class BianLiTree {

    /**
     * 前序
     */


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return result;

    }

    /**
     *      1
     *   2     3
     *  6 7   4  5
     *     8
     * @param root
     */
    public List<TreeNode> preOrderRecursion(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root);
        TreeNode left = root.left;
        if(left != null){
            result.addAll(preOrderRecursion(left));
        }
        TreeNode right = root.right;
        if(right != null){
            result.addAll(preOrderRecursion(right));
        }
        return result;
    }

    public static void main(String[] args) {
        BianLiTree bianLiTree = new BianLiTree();
        TreeNode tree = BSTreeUtil.createTree();
        List<TreeNode> treeNodes = bianLiTree.preOrderRecursion(tree);
        treeNodes.forEach( i -> System.out.println(i.val));
        List<Integer> integers = bianLiTree.preorderTraversal(tree);
        System.out.println(integers);
    }

    public List<TreeNode> preOrderInterator(TreeNode treeNode){
        return null;
    }

    /**
     * 中序
     */
    public List<Integer> inorderIterator(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        return result;
    }

    /**
     * 后序
     */

}
