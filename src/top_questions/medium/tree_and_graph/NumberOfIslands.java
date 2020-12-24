package top_questions.medium.tree_and_graph;

//https://leetcode.com/problems/number-of-islands/
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int isLands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    isLands++;
                    dfs(i, j, grid);
                }
                
            }
        }
        
        return isLands;
        
    }
    
    private void dfs(int i, int j, char[][] grid){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        
        
        
    }
}