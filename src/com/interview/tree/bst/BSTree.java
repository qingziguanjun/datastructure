package com.interview.tree.bst;

import sun.net.util.IPAddressUtil;

import java.util.Stack;

/**
 * @author songyi
 * @date 2020-03-17 07:28
 * @Description: 二叉查找树：首先最基础的 get  put 方法
 *  接着 ：min max rank(k) select floor  ceiling
 */
public class BSTree {
    public static void main(String[] args) {
        int[] arr = {4,2,5,3,1,6};
        TreeNode root= new TreeNode(arr[0]);
        //todo 能够把数组转化成二叉查找树
        BSTree bsTree = new BSTree();
        for(int i = 1; i < arr.length; i++){
            bsTree.putByIteration(root, arr[i]);
        }
        bsTree.inOrder(root);
    }

    public int get(TreeNode root, int val){
        return -1;
    }

    public void put(TreeNode root, int val){

        if(root.val > val){
            if(root.left != null) {
                put(root.left, val);
            }else{
                root.left = new TreeNode(val);
            }
        }

        if(root.val < val){
            if(root.right != null) {
                put(root.right, val);
            }else{
                root.right = new TreeNode(val);
            }
        }
    }

    public void putByIteration(TreeNode root, int val){
        while (root != null){
            if(root.val > val){
                if(root.left != null) {
                    root = root.left;
                }else{
                    root.left = new TreeNode(val);
                    return;
                }
            }

            if(root.val < val){
                if(root.right != null) {
                    root = root.right;
                }else{
                    root.right = new TreeNode(val);
                    return;
                }
            }
        }
    }
    //递归这棵树，中序遍历
    public void  inOrder(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            inOrder(root.left);
        }
        System.out.println(root.val);
        if(root.right != null){
            inOrder(root.right);
        }
    }

    //迭代遍历，先序
    public void preOrderIteration(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    //todo  没有记住 迭代遍历，中序
    public void inOrderIteration(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //stack.push();
        while (!stack.isEmpty()){

        }
    }
}
