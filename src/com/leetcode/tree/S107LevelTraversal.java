package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author songyi
 * @date 2020-03-28 21:10
 * @Description:https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class S107LevelTraversal {
    /**
     * ��һ��queue��ÿ�α�������һ������ݣ�Ȼ�����һ�����ݵ�ÿ���ڵ�������ӽڵ㶼�Ž�ȥ
     * result.addFirst ÿ�ΰѱ�������һ��ŵ�ͷ�����Ǵӵײ��������ĳ� add���Ǵ�������
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // ÿ�ζ�ȡ��һ�����������
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // ÿ�ζ�����ͷ��
            result.add(oneLevel);
        }
        return result;
    }

    /**
     * ��һ��queue��ÿ�α�������һ������ݣ�Ȼ�����һ�����ݵ�ÿ���ڵ�������ӽڵ㶼�Ž�ȥ
     * result.addFirst ÿ�ΰѱ�������һ��ŵ�ͷ�����Ǵӵײ��������ĳ� add���Ǵ�������
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> oneLevel = new LinkedList<>();
            // ÿ�ζ�ȡ��һ�����������
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if(level % 2 == 0) {
                    oneLevel.add(node.val);
                }else {
                    oneLevel.addFirst(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
            // ÿ�ζ�����ͷ��
            result.add(oneLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        S107LevelTraversal s = new S107LevelTraversal();
        TreeNode tree = BSTreeUtil.createTree();
        List<List<Integer>> lists = s.levelOrderBottom(tree);
        List<List<Integer>> lists1 = s.zigzagLevelOrder(tree);
        System.out.println(lists);
        System.out.println(lists1);
    }
}
