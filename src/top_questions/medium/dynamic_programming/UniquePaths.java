package top_questions.medium.dynamic_programming;
//https://leetcode.com/problems/unique-paths/
class UniquePaths {
    Integer[][] dp;
    boolean initialize;
    public int uniquePaths(int m, int n) {
        if(!initialize){
            dp = new Integer[m+1][n+1];
            initialize=true;
        }
        if(m==1 && n==1)
            return 1;
        if(dp[m][n]!=null)
            return dp[m][n];
        int uStraight = n==1?0:uniquePaths(m, n-1);
        int uDown  = m==1?0:uniquePaths(m-1, n);
        
        return dp[m][n] = uStraight + uDown;
        
        
         
    }
    
    
}