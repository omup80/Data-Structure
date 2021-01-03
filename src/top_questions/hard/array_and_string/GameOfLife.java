package top_questions.hard.array_and_string;
//https://leetcode.com/problems/game-of-life/
class GameOfLife {
    public void gameOfLife(int[][] board) {
        
        
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                int live = vertical(r, c, board)+horizontal(r,c, board)+diagonal(r,c, board);
                if(live<2 && board[r][c]==1)
                    board[r][c]=2;
                if(live>3 && board[r][c]==1)
                    board[r][c]=2;
                if(live==3 && board[r][c]==0)
                    board[r][c]=-1;
                
            }
            
            
        }
        
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c]==2)
                    board[r][c]=0;
                else if(board[r][c]==-1)
                    board[r][c]=1;
            }
                
        }
        
    }
    
    public int vertical(int r, int c, int[][] board){
        int count=0;
        if(r!=0)
            if(board[r-1][c]>0)
                count++;
            
        if(r!=board.length-1)
            if(board[r+1][c]>0)
                count++;
        
        return count;
    }
    
    public int horizontal(int r, int c, int[][] board){
        int count=0;
        if(c!=0)
            if(board[r][c-1]>0)
                count++;
        if(c<board[0].length-1)
            if(board[r][c+1]>0)
                count++;
        
        return count;
        
    }
    
    public int diagonal(int r, int c, int[][] board){
        int count=0;
        if(r>0 && c>0)
            if(board[r-1][c-1]>0)
                count++;
        if(r<board.length-1 && c<board[0].length-1)
            if(board[r+1][c+1]>0)
                count++;
        
        if(r>0 && c<board[0].length-1)
            if(board[r-1][c+1]>0)
                count++;
        if(r<board.length-1 && c>0)
            if(board[r+1][c-1]>0)
                count++;
        return count;
    }
}