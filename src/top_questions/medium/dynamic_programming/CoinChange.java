package top_questions.medium.dynamic_programming;

import java.util.Arrays;
//https://leetcode.com/problems/coin-change/
class CoinChange {
    int[] dp;
    boolean initialize;
    public int coinChange(int[] coins, int amount) {
        if(!initialize){
            System.out.println(amount);
            dp = new int[amount+1];
            initialize = true;
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0]=0;
        }
        
        if(amount<0)
            return -1;
        
        if(dp[amount]!=Integer.MAX_VALUE)
            return dp[amount];
        
        for(int coin: coins){
            int res = coinChange(coins, amount-coin);
            if(res >=0 && res<Integer.MAX_VALUE)
                dp[amount] = Math.min(dp[amount], 1+res);
        }
        
        return dp[amount]= dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}