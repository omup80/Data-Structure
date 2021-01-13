package top_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children = new HashMap();
    String word=null;
}

class Solution {
    TrieNode root;
    List<String> result = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(Character c: word.toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }else{
                    TrieNode t = new TrieNode();
                    node.children.put(c, t);
                    node = t;
                }
            }
            
            node.word = word;    
        }
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.children.containsKey(board[i][j]))
                    backtrack(i, j, board, root);
            }
        }
        
        return result;
        
    }
    
    public void backtrack(int i, int j, char[][] board, TrieNode node){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || !node.children.containsKey(board[i][j]))
            return;
        
        //System.out.println(board[i][j]);

            
        
        
        node = node.children.get(board[i][j]);
        if(node.word!=null){
            result.add(node.word);
            node.word=null;
        }
            
        char temp = board[i][j];
        board[i][j]='#';
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d: dir){
            int x = d[0]+i;
            int y = d[1]+j;
            backtrack(x, y, board, node);
        }
        
        board[i][j] = temp;
        
        
    }
}