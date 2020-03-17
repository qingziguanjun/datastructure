package com.interview.tree.bst;

import java.util.Stack;

/**
 * @author songyi
 * @date 2020-03-17 07:28
 * @Description: ���������������������� get  put ����
 *  ���� ��min max rank(k) select floor  ceiling
 */
public class BSTree {
    public static void main(String[] args) {
        int[] arr = {4,2,5,3,1,6};
        //todo �ܹ�������ת���ɶ��������
        TreeNode tree = BSTreeUtil.createTree();
        BSTree bsTree = new BSTree();
        bsTree.inOrder(tree);
    }

    public int get(TreeNode root, int val){
        return -1;
    }

    public void put(TreeNode root, int val){
        if(root == null)  {
            root = new TreeNode(val);
        }
        if(root.left != null && root.val > val){
            put(root.left, val);
        }

        if(root.right != null && root.val < val){
            put(root.left, val);
        }
    }
    //�ݹ���������������
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

    //��������������
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

    //todo  û�м�ס ��������������
    public void inOrderIteration(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //stack.push();
        while (!stack.isEmpty()){

        }
    }
}
