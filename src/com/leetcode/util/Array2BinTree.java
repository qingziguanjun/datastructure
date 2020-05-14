package com.leetcode.util;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;

import static java.lang.System.out;

/**
 * 数组转二叉树
 * 测试用例:
 *{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
 * Integer.MIN_VALUE代表空节点#
 * Created by ZeHua on 2017/5/13.
 */
public class Array2BinTree {
    /**
     * 用树的层次遍历的方法转二叉树
     * @param array
     * @return
     */
    public static TreeNode array2BinTree(int[] array){
        if(array.length==0){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(array[index++]);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(index<array.length){
                cur.left=new TreeNode(array[index++]);
                if(cur.left.val!=Integer.MIN_VALUE){
                    queue.add(cur.left);
                }else {//空结点不入队
                    cur.left=null;
                }

            }
            if(index<array.length){
                cur.right=new TreeNode(array[index++]);
                if(cur.right.val!=Integer.MIN_VALUE){
                    queue.add(cur.right);
                }else {//空结点不入队
                    cur.right=null;
                }

            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] a1 = {8,8,7,9,2,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,4,7};
        int[] a2 = {8,9,2};
        TreeNode t1 = array2BinTree(a1);
        TreeNode t2 = array2BinTree(a2);
        out.println();
    }
}
