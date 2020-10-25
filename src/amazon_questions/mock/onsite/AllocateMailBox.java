package amazon_questions.mock.onsite;

import java.util.Arrays;

class AllocateMailBox {
    int[][] cost;
    int n;
    Integer[][] memo;
    Integer MAX = 100000;
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        cost = new int[n][n];
        memo = new Integer[k+1][n+1];
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int t=i;t<=j;t++){
                    cost[i][j] += Math.abs(houses[(i+j)/2] - houses[t]);
                    cost[j][i] += Math.abs(houses[(i+j)/2] - houses[t]);
                }
            }
        }
        return dp(k, 0);
    }
    
    private int dp(int k,int i){
        if(k==0 && i==n)
            return 0;
        if(k==0 || i==n)
            return MAX;
        if(memo[k][i]!=null)
            return memo[k][i];
        
        int ans = MAX;
        for(int j=i;j<n;j++){
            ans = Math.min(ans, cost[i][j]+dp(k-1, j+1));
        }
        
        return memo[k][i]=ans;
    }
}