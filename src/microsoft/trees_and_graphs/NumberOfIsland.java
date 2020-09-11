package microsoft.trees_and_graphs;
//https://leetcode.com/problems/number-of-islands/submissions/
//200. Number of Islands
class NumberOfIsland {
    public int numIslands(char[][] grid) {
      int count=0;
      if(grid.length==0)
          return count;
      int nr = grid.length;
      int nc = grid[0].length;
      for(int r=0;r<nr;r++){
          for(int c=0;c<nc;c++){
              if(grid[r][c]=='1'){
                  count++;
                  dfs(grid, r, c, nc, nr);
              }
                  
          }
          
          
      }      
        return count;
  }
    
 private void dfs(char[][] grid, int r, int c,int nc,int nr){
     if(r<0 || r>nr-1 || c<0 || c>nc-1||grid[r][c]=='0')
         return;
     
     grid[r][c]='0';
     
     dfs(grid, r-1, c, nc, nr);
     dfs(grid, r+1, c, nc, nr);
     dfs(grid, r, c-1, nc, nr);
     dfs(grid, r, c+1, nc, nr);
     
     
 }   
    
}