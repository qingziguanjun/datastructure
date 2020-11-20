package com.train1112.tree;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.*;

/**
 * @author songyi
 * @date 2020-11-12 17:27
 * @Description: °´²ã±éÀú
 */
public class LevelBianliTree {

    /**
     *      1
     *   2     3
     *  6 7   4  5
     *     8
     */

    /**
     * µÝ¹é
     */
    public List<List<Integer>> levelRecu(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {return result;}
        helper(result, 0, root);
        return result;
    }

    public void helper(List<List<Integer>> result, int level, TreeNode root){
        if(result.size() == level){
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(level).add(root.val);
        if(root.left != null) {
            helper(result, level + 1, root.left);
        }
        if(root.right != null) {
            helper(result, level + 1, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = BSTreeUtil.createTree();
        LevelBianliTree levelBianliTree = new LevelBianliTree();
        List<List<Integer>> lists = levelBianliTree.levelRecu(tree);
        System.out.println(lists);
        List<List<Integer>> lists1 = levelBianliTree.levelIterator(tree);
        System.out.println(lists1);
    }
    /**
     * µü´ú
     */

    public List<List<Integer>> levelIterator(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);

        }
        return result;
    }
}
