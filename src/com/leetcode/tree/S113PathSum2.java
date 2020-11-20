package com.leetcode.tree;

import java.util.*;

/**
  @author songyi
  @date 2020-04-02 13:09
  @Description:
  作者：LeetCode-Solution
  链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class S113PathSum2 {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }






    //迭代实现##################################
    //List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSumItr(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }



    public static void main(String[] args) {
        S113PathSum2 s = new S113PathSum2();
        TreeNode tree = BSTreeUtil.createTree();


        List<List<Integer>> lists = s.pathSum(tree, 9);
        System.out.println(lists);

        List<List<Integer>> list1 = s.pathSumSelfRecur(tree, 9);
        System.out.println(list1);
    }

    //##########自己写
    List<List<Integer>> rel = new ArrayList<>();
    public List<List<Integer>> pathSumSelfRecur(TreeNode root, int sum) {

        if(root == null){ return  rel;}
        List<Integer> tem = new ArrayList();
        dfs(root, tem, sum);

        return rel;
    }

    void dfs(TreeNode treeNode, List<Integer> list, int sum){
        if(treeNode.left == null && treeNode.right == null){
            if(treeNode.val == sum){
                List<Integer> t = new ArrayList<>();
                t.addAll(list);
                t.add(treeNode.val);
                rel.add(t);
            }
        }
        list.add(treeNode.val);

        if(treeNode.left != null){
            dfs(treeNode.left, list, sum - treeNode.val);
        }

        if(treeNode.right != null){
            dfs(treeNode.right, list, sum - treeNode.val);
        }
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSumSelfIter(TreeNode root, int sum) {
        if(root == null){ return  rel;}
        Stack<TreeNode> treeNodes = new Stack<>();
        Stack<List<Integer>> valueStack = new Stack<>();
        treeNodes.push(root);
        valueStack.push(new ArrayList<>());

        while (!treeNodes.isEmpty()){
            TreeNode pop = treeNodes.pop();
            List<Integer> integers = valueStack.pop();
            if(pop.left == null && pop.right == null){
            }
        }







        return rel;
    }











}
