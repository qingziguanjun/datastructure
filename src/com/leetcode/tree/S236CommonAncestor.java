package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-04-13 08:03
 * @Description:
 */
public class S236CommonAncestor {


    //#####################

    /**
     * 作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private TreeNode ans;

    public S236CommonAncestor() {
        // Variable to store LCA node.
        this.ans = null;
    }

    /**
     * 三种情况
     * 1.p，q分别在左右子树
     * 2.p q 在同一个左子树
     * 3.p q在同一个右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return false; }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        boolean leftAndRight = lson && rson;
        boolean left = (root.val == p.val || root.val == q.val) && lson;
        boolean right = (root.val == p.val || root.val == q.val) && rson;
        if (leftAndRight || left || right) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }



}
