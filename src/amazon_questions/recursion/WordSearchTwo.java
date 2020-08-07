package amazon_questions.recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class WordSearchTwo {
 char [][] board ;
 int nr;
 int nc;
 List<String> result = new ArrayList<String>();   
public List<String> findWords(char[][] board, String[] words) {
    this.board = board;
    nr = board.length;
    nc = board[0].length;
 //create trie N tree
 TrieNode root = createTrie(words);
    
 //search first matching character in trie and do backtracking

    
    for(int r=0;r<nr;r++){
        for(int c=0;c<nc;c++){
            if(root.children.containsKey(board[r][c])){
                backTrack(r, c, root);
            }
        } 
    }   

  //return the result 
return result;
    
}

private void backTrack(int r, int c, TrieNode parent){
    if(parent.word != null){
        result.add(parent.word);
        parent.word = null;
    }
    if(r<0 || r> nr-1 || c<0 || c> nc-1 || !parent.children.containsKey(board[r][c]))
        return;
    
    char letter = board[r][c];
    TrieNode currNode = parent.children.get(letter);
    board[r][c]='#';
    backTrack(r+1, c, currNode);
    backTrack(r-1, c, currNode);
    backTrack(r, c+1, currNode);
    backTrack(r, c-1, currNode);
    board[r][c] = letter;
    if(currNode.children.isEmpty()){
        parent.children.remove(letter);
    }
    
} 
    

private TrieNode createTrie(String[] words){
    
    TrieNode root = new TrieNode();
    TrieNode node = root;
    for(String word: words){
      node = root;  
      for(char letter: word.toCharArray()){
            if(node.children.containsKey(letter)){
                node = node.children.get(letter);
            }else{
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
                node = newNode; 
            }      
            
      }
        
      node.word = word;
        
    }  
      
  return root;    
}

}

class TrieNode {

    String word=null;
    Map<Character, TrieNode> children;
    TrieNode(){
        children = new HashMap<Character, TrieNode>();
    }
}
