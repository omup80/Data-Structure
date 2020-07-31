package amazon_questions.trees_and_graph;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 */
class NumberOfIsland {
    public int numIslands(char[][] grid) {
       int numberOfIsland = 0;
       if(grid==null || grid.length==0)
           return numberOfIsland;
       
       int nr = grid.length;
       int nc = grid[0].length;
        
        for(int r=0;r<nr;r++){
            for(int c=0;c<nc;c++){
                if(grid[r][c]=='1'){
                    numberOfIsland++;
                    dfs(grid, r, c, nr, nc);
                    
                }
                    
            }
            
        }
        
        return numberOfIsland;
        
    }
    
    private void dfs(char[][] grid, int r, int c, int nr, int nc){
        if(r<0 || c<0 || r==nr || c==nc|| grid[r][c]=='0')
            return;
        
        grid[r][c]='0';
        dfs(grid, r-1,c, nr,nc);
        dfs(grid, r+1,c, nr,nc);
        dfs(grid, r,c-1, nr,nc);
        dfs(grid, r,c+1, nr,nc);
        
    }
        
}
  