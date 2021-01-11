package top_questions.hard.trees;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class LongestIncreasingPath {
    int[][] dir = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1} };
    public int longestIncreasingPath(int[][] matrix) {
        int maxHeight=0;
        
        if(matrix.length==0)
            return maxHeight;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                    int height = dfs(i, j, matrix, dp);  
                    maxHeight = Math.max(height, maxHeight);
                
                    
            }
        }
        return maxHeight;
        
    }
    
    private int dfs(int i, int j, int[][] matrix, Integer[][] dp){
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        int height=1;
        for(int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x>=0 && x< matrix.length && y>=0 && y< matrix[0].length && matrix[x][y]>matrix[i][j]){
                int h = 1 + dfs(x, y, matrix, dp);
                height = Math.max(h, height);
            }
            
        }
            dp[i][j] = height;
            return height;
            
       
    }
}