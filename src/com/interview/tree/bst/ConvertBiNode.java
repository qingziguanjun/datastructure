package com.interview.tree.bst;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author songyi
 * @date 2020-03-10 08:06
 * @Description:
 */
public class ConvertBiNode {
    public TreeNode convertBiNode(TreeNode root) {
        if(root == null) return null;
        TreeNode result = null;
        if(root.left != null){
            result = getLeft(root.left);
        }

        if(root.right != null){

        }
        return null;
    }

    public TreeNode getLeft(TreeNode node){
        if(node.left == null) return node;
        TreeNode nodeLeft =  getLeft(node.left);
        TreeNode temp = nodeLeft.right;
        while (temp != null){
            temp = node.right;
        }
        temp.left = null;
        temp.right = node;
        return nodeLeft;

    }

    /**
     * 1.�ǵݹ飬BST�������������ģ�����ֻҪ������������������ɣ�����һ��ǰ���ڵ�prev����¼��һ��������Ľڵ㣬��ǰ�ڵ㱻��������ʱ�򣬽�prev.rightָ��ǰ�ڵ�node��Ȼ��node.left�ÿգ�prevָ����Ƶ�node,���node�������������ɡ�
     *
     * ���ߣ�shi-huo-de-xia-tian
     * ���ӣ�https://leetcode-cn.com/problems/binode-lcci/solution/zhong-xu-bian-li-di-gui-by-shi-huo-de-xia-tian/
     * @param root
     * @return
     */
    public TreeNode convertBiNodeAnswer(TreeNode root) {
        TreeNode head = new TreeNode(0);// �������ͷָ���ڱ�
        TreeNode prev = head;// �ƶ�������ǰ��ָ��
        // ��ʼ�������
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                // ---������
                node.left = null;// ��ǰ�ڵ���ָ���ÿ�
                prev.right = node;// ǰ��ָ����ָ��ָ��ǰ�ڵ㣬��Ϊ�����nextָ�룬��������Ԫ��
                prev = node;// ָ�����
                // ---������
                // �����������������
                node = node.right;
            }
        }
        return head.right;
    }

}
