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
     * 1.非递归，BST中序遍历是有序的，我们只要对树进行中序遍历即可，利用一个前驱节点prev，记录上一个被处理的节点，当前节点被遍历到的时候，将prev.right指向当前节点node，然后node.left置空，prev指针后移到node,最后node进入右子树即可。
     *
     * 作者：shi-huo-de-xia-tian
     * 链接：https://leetcode-cn.com/problems/binode-lcci/solution/zhong-xu-bian-li-di-gui-by-shi-huo-de-xia-tian/
     * @param root
     * @return
     */
    public TreeNode convertBiNodeAnswer(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        TreeNode prev = head;// 移动的链表前置指针
        // 开始中序遍历
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                // ---链表处理
                node.left = null;// 当前节点左指针置空
                prev.right = node;// 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
                prev = node;// 指针后移
                // ---链表处理
                // 中序遍历进入右子树
                node = node.right;
            }
        }
        return head.right;
    }

}
