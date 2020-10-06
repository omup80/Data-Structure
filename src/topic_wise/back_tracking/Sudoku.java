package topic_wise.back_tracking;

class Sudoku {
    
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        solve();
    }
    
    
    private boolean solve(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                   for(char c='1';c<='9';c++){
                       if(isValid(i, j,c)){
                           board[i][j] = c;
                           if(solve())
                               return true;
                           else
                               board[i][j]='.';
                       }
                   } 
                   return false; 
                }
            }
        }
       return true; 
    }
    private boolean isValid(int r, int c, char val){
        for(int i=0;i<9;i++){
            if(board[r][i]==val)
                return false;
            if(board[i][c]==val)
                return false;
            if(boxContain(r,c,i, val))
                return false;
        }
        return true;
    }
    
    private boolean boxContain(int r , int c, int i, char val){
        int box = boxNumber(r, c);
        int boxRow = (box/3)*3+ i/3;
        int boxCol = (box%3)*3+ (i%3);
        if(board[boxRow][boxCol]==val)
            return true;
         return false;   
    }
    
    private int boxNumber(int r, int c){
        return (r/3)*3 + (c/3);
    }
       
}