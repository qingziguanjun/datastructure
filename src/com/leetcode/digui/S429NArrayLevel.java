package com.leetcode.digui;

import com.algs4.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-09 11:52
 * @Description:
 */
public class S429NArrayLevel {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==  null){
            return result;
        }
        helper(1, root.children, result);
        return result;
    }
    public List<Integer> helper(int level,List<Node> children, List<List<Integer>> result ){
        if(children == null){
            return null;
        }
        List<Integer> integers = result.get(level);
        if(integers == null){
            integers = new ArrayList<>();
            result.add(integers);
        }
        for(Node node :children){
            integers.add(node.val);
            helper(level+1, node.children, result);
        }
        return  null;

    }


    //下次才是正确的
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
