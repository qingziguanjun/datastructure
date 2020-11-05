package com.leetcode.tree;


import com.algs4.algs4.In;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author songyi
 * @date 2020-09-18 10:07
 * @Description:
 */
public class SelfWork {
    // s102
    List<List<Integer>> list = new ArrayList<>();
    //°´²ã´òÓ¡Ê÷
    public List<List<Integer>> level(TreeNode root){
        if(root == null ){
            return list;
        }
        helper(root, 0);
        return list;
    }

    public void  helper(TreeNode node, int level){
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        List<Integer> integers = list.get(level);
        integers.add(node.getVal());
        if(node.left != null){
            helper(node.left, level+1);
        }

        if(node.right != null){
            helper(node.right, level+1);
        }
    }

    public static void main(String[] args) {
        SelfWork s = new SelfWork();
        TreeNode tree = BSTreeUtil.createTree();
        List<List<Integer>> lists = s.level(tree);
        System.out.println(lists);
        List<List<Integer>> lists1 = s.levelIter(tree);
        System.out.println(lists1);
    }

    //s102±éÀú
    public List<List<Integer>> levelIter(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) { return list; }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> integers = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                integers.add(node.getVal());
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(integers);
        }
       return list;
    }

}
