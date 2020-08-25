package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-17 19:16
 * @Description:
 */
public class S515LargeEachRow {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if(res.size() == level){
            res.add(root.val);
        }
        int max = res.get(level);
        if(max < root.val){
            res.remove(level);
            res.add(level, root.val);
        }
        if(root.left != null){
            helper(root.left, level+1);
        }

        if(root.right != null){
            helper(root.right, level+1);
        }

    }
}
