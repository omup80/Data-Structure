package google.trees_and_graphs;
//329. Longest Increasing Path in a Matrix
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class LongestIncreasingPath {
    int path=0;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return path;
        int nr=matrix.length;
        int nc=matrix[0].length;
        dp = new int[nr][nc];
        
        for(int r=0;r<nr;r++){
            for(int c=0;c<nc;c++){
              path = Math.max(path, dfs(matrix, r, c, nr, nc));
            }
        }
        
        return path;
    }
    
    private int dfs(int[][] matrix, int r, int c, int nr, int nc){
        
        if(dp[r][c]!=0)
            return dp[r][c];
         
        dp[r][c]=1;
        if(r+1!=nr && matrix[r+1][c]>matrix[r][c])
           dp[r][c]= Math.max(dp[r][c], dfs(matrix, r+1, c, nr, nc)+1);
        
        if(r-1>=0 && matrix[r-1][c]>matrix[r][c])
           dp[r][c] = Math.max(dp[r][c], dfs(matrix, r-1, c, nr, nc)+1);
            
        if(c+1!=nc && matrix[r][c+1]>matrix[r][c])
         dp[r][c] = Math.max(dp[r][c], dfs(matrix, r, c+1, nr, nc)+1);
        
        if(c-1>=0 && matrix[r][c-1]>matrix[r][c])    
         dp[r][c] = Math.max(dp[r][c], dfs(matrix, r, c-1, nr, nc)+1);
        
        
        return dp[r][c];
        
        
    }
}