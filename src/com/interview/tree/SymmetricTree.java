package com.interview.tree;

/**
 * @author songyi
 * @date 2020-03-03 09:32
 * @Description:
 * 先解决树相同的问题：https://leetcode-cn.com/problems/same-tree/
 * 在解决对称的问题：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    //todo 迭代也需要掌握
    // 先回递归判断树一样，然后改一下就是对称判断了
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);

    }

    public boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q== null ) return false;
        if(p.val == q.val && isMirror(p.left, q.right)
                && isMirror(p.right, q.left)){
            return true;
        }
        return false;
    }

    //递归判断两个树是否相等
    //todo 迭代也需要掌握
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q== null ) return false;
        if(p.val == q.val && isSameTree(p.left, q.left)
           && isSameTree(p.right, q.right)){
            return true;
        }
        return false;
    }
}
