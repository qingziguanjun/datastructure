package com.leetcode.tree;

/**
 * @author songyi
 * @date 2020-08-17 19:49
 * @Description: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class S124MaxPathSumn {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // �ݹ���������ӽڵ�������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ�ӽڵ�
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewpath = node.val + leftGain + rightGain;

        // ���´�
        maxSum = Math.max(maxSum, priceNewpath);

        // ���ؽڵ�������ֵ
        return node.val + Math.max(leftGain, rightGain);
    }

}
