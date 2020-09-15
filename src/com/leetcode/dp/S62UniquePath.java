package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-08-31 13:28
 * @Description:
 */
public class S62UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int j = 0; j < m; j++){
            dp[j][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1;  j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 作者：powcai
     *     链接：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }





    public static void main(String[] args) {
        S62UniquePath s = new S62UniquePath();
//        int num = s.uniquePaths(3, 2);
//        int num2 = s.uniquePaths(7, 3);
//        System.out.println(num);
//        System.out.println(num2);

        int[][]  a = {{0,0,0},{0,1,0},{0,0,0}};
        int[][]  a1 = {{1,0}};

    }
}
