package com.leetcode.digui;

import com.algs4.algs4.In;
import javafx.scene.layout.StackPaneBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author songyi
 * @date 2020-08-08 20:23
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class S589NTreePreOrder {

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


    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        for(Node child: root.children){
            result.addAll(preorder(child));
        }
        return result;
    }


    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            List<Node> childer = node.children;
            for(int i = childer.size() -1; i >= 0; i--){
                stack.push(childer.get(i));
            }
        }
        return result;
    }

}
