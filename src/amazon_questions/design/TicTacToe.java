package amazon_questions.design;
//https://leetcode.com/problems/design-tic-tac-toe/
//348. Design Tic-Tac-Toe
class TicTacToe {

    /** Initialize your data structure here. */
    int [][] X;
    int [] X_dig;
    int [][] O;
    int [] O_dig;
    int n;
    public TicTacToe(int n) {
        X= new int[n][2];
        O = new int[n][2];
        X_dig = new int[2];
        O_dig = new int[2];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player==1){
            X[row][0] = X[row][0]+1; 
            X[col][1] = X[col][1]+1;
            if(row==col)
                X_dig[0]= X_dig[0]+1;
            if(row==n-1-col)
                X_dig[1] = X_dig[1]+1;
            if(X[row][0] ==n|| X[col][1]==n || X_dig[0]==n|| X_dig[1]==n)
                return 1;
        }else{
            O[row][0] = O[row][0]+1; 
            O[col][1] = O[col][1]+1;
            if(row==col)
                O_dig[0]= O_dig[0]+1;
            if(row==n-1-col)
                O_dig[1] = O_dig[1]+1;
            if(O[row][0] ==n|| O[col][1]==n || O_dig[0]==n|| O_dig[1]==n)
                return 2;
        } 
        
        return 0;
    }
    
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */