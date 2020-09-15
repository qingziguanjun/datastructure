package com.leetcode.dp;

/**
 * ���ߣ�LeetCode-Solution
 * ���ӣ�https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
class S63ObstaclePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                //obstacleGrid[i][j - 1] ��ߵ�
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

    public int uniquePathsWithObstaclesWrong(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            }else {
                dp[0][i] = 1;
            }
        }
        for(int j = 0; j < m; j++){
            if(obstacleGrid[j][0] == 1) {
                dp[j][0] = 0;
            }else {
                dp[j][0] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1;  j < n; j++){
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     *  ���ߣ�sweetiee
     *     ���ӣ�https://leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/
     *     ��Դ�����ۣ�LeetCode��
     *     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesCmp(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // ���� dp ���鲢��ʼ���� 1 �к͵� 1 �С�
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // ����״̬ת�Ʒ��� dp[i][j] = dp[i - 1][j] + dp[i][j - 1] ���е��ơ�
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        S63ObstaclePath s = new S63ObstaclePath();
        int[][]  a1 = {{1,0}};
        int i = s.uniquePathsWithObstaclesCmp(a1);
        System.out.println(i);
        int i2 = s.uniquePathsWithObstaclesWrong(a1);
        System.out.println(i2);
    }

}

