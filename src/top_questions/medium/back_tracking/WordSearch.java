package top_questions.medium.back_tracking;
//https://leetcode.com/problems/word-search/
class WordSearch {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        if(word.length()>board.length*board[0].length)
            return false;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, board,word, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board,String word, int index){
        
        if(index==word.length())
            return true;
        if(i<0 || i==board.length || j<0 || j==board[0].length || board[i][j] != word.charAt(index))
            return false;
        
        char temp = board[i][j];
        board[i][j]='#';
        for(int[] d: dir){
            int newR = i+d[0];
            int newC = j+d[1];
            if(dfs(newR, newC, board, word, index+1))
                return true;
        }
        board[i][j]=temp;
        return false;
    }
}