package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-03-24 22:14
 * @Description:
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 输入n 所有的 二叉搜索树
 */
public class Solution9596UniqueBts {

    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }

    public static void main(String[] args) {
        Solution9596UniqueBts solution94InOrderTraversal = new Solution9596UniqueBts();
        LinkedList<TreeNode> treeNodes = solution94InOrderTraversal.generate_trees(1, 3);
        int num = solution94InOrderTraversal.numTrees(5);
        System.out.println(num);
    }

    /**
     *  https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i+1 ; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }

}
