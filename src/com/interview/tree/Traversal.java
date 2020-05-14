package com.interview.tree;

import java.util.*;

/**
 * @author songyi
 * @date 2020-03-01 06:41
 * @Description:
 * �������ı�����
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
     * ���������ǵݹ������ܼ򵥣������е��Ѱ�
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
     * todo ���������õ���
     * �����е��Ѱ�
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
            //��push�ұ�
            if(node.right != null){
                stack.push(node.right);
            }
            //��push���
            if(node.left != null){
                stack.push(node.left);
            }

        }
        return result;
    }
    /**
     * ���� ����
     * �Ȳ���
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
            //���ڵ�ǰ����root���Ƚ�ȥ������֮Ҫ��left�ͽ�ȥ
            //����һ��left����� ����right��Ϊ�վͽ�ȥ�����ڷ�Ҷ�ӽڵ��ǵ�����ǰ�ڴ����ң�Ҷ�ӽڵ��right�϶���null
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //���ﵯ������ߵģ�Ȼ�����
            //��������ߵ������������null�� ����while��ִ�У������������Ǹ��ڵ㣬�����Ǹ��ڵ�����ӽڵ��Ƿ���ڣ������ڼ�������pop�����־�push���µ�����
            // �������������null����ô��������push��ȥ��
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;

    }

    /**
     * todo �������
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
