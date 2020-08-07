package amazon_questions.recursion;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
class WordSearch {
    boolean isExist=false;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;
        this.board = board;
        char[] ch = word.toCharArray();
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
               if(board[i][j] == ch[0]){
                   searchWord(i,j, nr, nc, ch,0, new boolean[nr][nc]);
                   if(isExist)
                       return true;
               } 
            }
        }
       return false; 
    }
    
    private void searchWord(int r, int c, int nr, int nc, char[] word,int index, boolean[][] visited){
        
        
        
        if( board[r][c]!=word[index])
            return;
        
        
        visited[r][c] = true;
        if(word.length-1==index){
            isExist = true;
            return;
        }
        if(!isExist && r+1<nr && !visited[r+1][c] ) searchWord(r+1, c, nr, nc, word,index+1, visited);
        if(!isExist && r-1>=0 && !visited[r-1][c])  searchWord(r-1, c, nr, nc, word,index+1, visited);
        if(!isExist && c+1<nc && !visited[r][c+1]  ) searchWord(r, c+1, nr, nc, word,index+1, visited);
        if(!isExist && c-1>=0 && !visited[r][c-1] ) searchWord(r, c-1, nr, nc, word,index+1, visited);
        visited[r][c]=false;
    }
}