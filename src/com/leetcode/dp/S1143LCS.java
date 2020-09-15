package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-09-03 11:16
 * @Description:
 */
public class S1143LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.deepToString(dp));
            for (int j = 0; j < n; j++) {
                // ��ȡ�������ַ�
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // ȥ������ǰ�����һ���ֵ��1����
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //Ҫô��text1��ǰ��һ��Ҫô��text2��ǰ��һ�����������ֵ
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String t1 = "ADBGGEGGG";
        String t2 = "AFBGGd";
        S1143LCS s = new S1143LCS();
        int result = s.longestCommonSubsequence(t1, t2);
        System.out.println(result);
    }
}
