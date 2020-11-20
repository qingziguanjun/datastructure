package com.leetcode.tree;

import com.interview.tree.MaxDepth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author songyi
 * @date 2020-04-16 09:32
 * @Description:
 */
public class S257TreePath {

    //["1->2->5", "1->3"]



    public int rob(int[] nums) {
        int num1 = 0 , num2 = 0;
        for(int i=0; i < nums.length; i++){
            if(i % 2 == 0){
                num1 += nums[i];
            }else {
                num2 += nums[i];
            }
        }
        return Math.max(num1, num2);
    }

    public static  int rob1(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, new ArrayList<>());
        for(int i = 0; i < result.size(); i++){
            List<Integer> integers = result.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(integers.get(0));
            for(int j = 1; j < integers.size(); j++){
                sb.append("->").append(integers.get(j));
            }
            res.add(sb.toString());
        }
        return res;
    }

    List<List<Integer>> result = new ArrayList<>();
    public  void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        List<Integer> onePath = new ArrayList<>(list);
        onePath.add(root.val);
        //叶子
        if(root.left == null && root.right == null){
            result.add(onePath);
        }
        if(root.left != null){
            helper(root.left , onePath);
        }

        if(root.right != null){
            helper(root.right, onePath);
        }
    }

    /**
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode/
     * @param root
     * @param path
     * @param paths
     */
    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                paths.add(path);  // 把路径加入到答案中
            else {
                path += "->";  // 当前节点不是叶子节点，继续递归遍历
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }


    /**
     *  作者：LeetCode
     *     链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<String> binaryTreePathsIter(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null) {
            return paths;
        }

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }


    /**官网深度优先
     * 作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<String> binaryTreePathsDeepFirst(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }




    //###########自己写树的路径

    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明:?叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    List<String> rel = new ArrayList<>();
    public List<String> binaryTreePathsRecurSelf(TreeNode root) {

        if(root == null) {return rel;}
        helperPathRecur(root, root.val+"");
        return rel;
    }

    private void helperPathRecur(TreeNode root, String path) {
        if(root.left == null && root.right == null){
            //叶子节点
            rel.add(path);
            return;
        }
        if(root.left != null){
            helperPathRecur(root.left, path + "->" + root.left.val);
        }

        if(root.right != null){
            helperPathRecur(root.right, path + "->" + root.right.val);
        }
    }


    public List<String> binaryTreePathsIterSelf(TreeNode root) {
        List<String> rel = new ArrayList<>();
        if(root == null) {return rel;}
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.add(root);
        pathStack.add(String.valueOf(root.val));
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if(node.left == null && node.right == null){
                //叶子节点
                rel.add(path);
            }
            if(node.left != null){
                nodeStack.add(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
            if(node.right != null){
                nodeStack.add(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
        }
        return rel;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        S257TreePath s = new S257TreePath();
        List<String> strings = s.binaryTreePathsIter(node1);
        System.out.println(strings);

        List<String> strings1 = s.binaryTreePathsRecurSelf(node1);
        List<String> strings2 = s.binaryTreePathsIterSelf(node1);
        System.out.println(strings1);
        System.out.println(strings2);


    }


}
