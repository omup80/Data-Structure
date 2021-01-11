package top_questions.hard.trees;
//https://leetcode.com/problems/surrounded-regions/
class SurroundedRegions {
    public void solve(char[][] board) {
        if(board==null || board.length==0|| board[0].length==0)
            return;
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                dfs(i, 0, board);
            
            if(board[i][board[0].length-1]=='O')
                dfs(i, board[0].length-1, board);
        }
        
        
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                dfs(0, i, board);
            
            if(board[board.length-1][i]=='O')
                dfs(board.length-1, i, board);
        }
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='A')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
        
    }
    
    private void dfs(int i, int j, char[][] board){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O')
            return;
        //System.out.println(board[i][j]);
        board[i][j]='A';
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
        
        
    }
}