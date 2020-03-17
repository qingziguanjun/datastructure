package com.interview.tree;

/**
 * @author songyi
 * @date 2020-03-03 09:32
 * @Description:
 * �Ƚ������ͬ�����⣺https://leetcode-cn.com/problems/same-tree/
 * �ڽ���ԳƵ����⣺https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    //todo ����Ҳ��Ҫ����
    // �Ȼصݹ��ж���һ����Ȼ���һ�¾��ǶԳ��ж���
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

    //�ݹ��ж��������Ƿ����
    //todo ����Ҳ��Ҫ����
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
