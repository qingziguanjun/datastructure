package com.train1112.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author songyi
 * @date 2020-11-12 17:27
 * @Description: °´²ã±éÀú
 */
public class ZigaLevelBianliTree {

    /**
     *      1
     *   2     3
     *  6 7   4  5
     *     8
     */

    /**
     * µÝ¹é
     */
    public List<LinkedList<Integer>> levelRecu(TreeNode root){
        List<LinkedList<Integer>> result = new ArrayList<>();
        if(root == null) {return result;}
        helper(result, 0, root);
        return result;
    }

    //[[1], [2, 3], [6, 7, 4, 5], [8]]
    public void helper(List<LinkedList<Integer>> result, int level, TreeNode root){
        if(result.size() == level){
            LinkedList<Integer> list = new LinkedList<>();

            result.add(list);
        }
        if(level % 2 == 0) {
            result.get(level).add(root.val);
        }else {
            result.get(level).addLast(root.val);
        }
        if(root.left != null) {
            helper(result, level + 1, root.left);
        }
        if(root.right != null) {
            helper(result, level + 1, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = BSTreeUtil.createTree();
        ZigaLevelBianliTree levelBianliTree = new ZigaLevelBianliTree();
        List<LinkedList<Integer>> lists = levelBianliTree.levelRecu(tree);
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
