package com.interview.tree;

import java.util.*;

/**
 * @author songyi
 * @date 2020-03-01 06:41
 * @Description:
 * 二叉树的遍历：
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 */
public class Traversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        Traversal traversal = new Traversal();
        List<Integer> integers = traversal.postorderTraversal(node1);
        System.out.println(integers);
        List<Integer> integers1 = traversal.inorderTraversalIteration(node1);
        System.out.println(integers1);

    }

    /**
     * 下面三个是递归解决，很简单，迭代有点难啊
     *
     */


     /**
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(root.left != null){
            result.addAll(preorderTraversal(root.left));
        }
        if(root.right != null){
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(postorderTraversal(root.left));
        }
        if(root.right != null){
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }

    /**
     * todo 下面三个用迭代
     * 迭代有点难啊
     *
     */

    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            //先push右边
            if(node.right != null){
                stack.push(node.right);
            }
            //在push左边
            if(node.left != null){
                stack.push(node.left);
            }

        }
        return result;
    }
    /**
     * 迭代 中序
     * 先操作
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            //对于当前树，root最先进去，接着之要有left就进去
            //最后出一个left，如果 它的right不为空就进去，对于非叶子节点是弹出当前在处理右，叶子节点的right肯定是null
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //这里弹出最左边的，然后添加
            //接着最左边的右子树如果是null， 上面while不执行，继续弹出的是父节点，接着是父节点的右子节点是否存在，不存在继续往上pop，存现就push，新的子树
            // 如果右子树不是null，那么右子树被push进去，
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;

    }

    /**
     * todo 这个不对
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return result;
    }
}
