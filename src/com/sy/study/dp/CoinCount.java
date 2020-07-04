package com.sy.study.dp;


import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author songyi
 * @date 2020-06-01 12:18
 * @Description:
 */
public class CoinCount {
    /**
     *
     题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。
     比如说，k = 3，面值分别为 1，2，5，总金额 n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。下面走流程。
     作者：米奇罗
     链接：https://juejin.im/post/5d556b7ef265da03aa2568d5
     */

    private static  final  int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ThreadPoolExecutor a = null;
        int[] coin = {1,2,5};
        int sum = 11;
        CoinCount coinCount = new CoinCount();
        int minCount = coinCount.coinChange2(coin, sum);
        System.out.println(minCount);
    }
    public int getMinCount(int[] coins, int amount){
        if(amount == 0) return 0;
        if(coins[0] > amount) return -1;
        int count = 0;
        int coinNum = coins.length -1;
        int maxCoin = coins[coinNum--];
        while (amount > 0 && coinNum >= -1) {
            if (amount > maxCoin) {
                count++;
                amount -= maxCoin;
            }else {
                maxCoin = coins[coinNum--];
            }
        }
        if(count == 0) return -1;
        if(amount == 0) {
            return count;
        }else {
            return -1;
        }
    }

    /**
     * 递归实现
     * @param coins
     * @param amount
     * @return
     */
    int coinChange1(int[] coins, int amount) {
        System.out.println("amout = " + amount);
        if (amount == 0) return 0;
        int ans = INT_MAX;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProb == -1) continue;
            ans = Math.min(ans, subProb + 1);
        }
        return ans == INT_MAX ? -1 : ans;
    }


    /**
     * 带备忘录
     * @param coins
     * @param amount
     * @return
     */
    int coinChange(int[] coins, int amount) {
        // 备忘录初始化为 -2
        int[] memo = new int[amount + 1];
        for(int i = 0; i < memo.length; i++){
            memo[i] = -2;
        }
        return helper(coins, amount, memo);
    }

    int helper(int[] coins, int amount, int[] memo) {

        if (amount == 0) return 0;
        if (memo[amount] != -2) return memo[amount];
        System.out.println("amout = " + amount);
        int ans = INT_MAX;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = helper(coins, amount - coin, memo);
            // 子问题无解
            if (subProb == -1) continue;
            ans = Math.min(ans, subProb + 1);
        }
        // 记录本轮答案
        memo[amount] = (ans == INT_MAX) ? -1 : ans;
        return memo[amount];
    }


    /**
     * 动态规划，自底向上
     * @param amount
     * @return
     */
    int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins)
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }




}
