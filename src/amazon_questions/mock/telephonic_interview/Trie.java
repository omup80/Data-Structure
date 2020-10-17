package amazon_questions.mock.telephonic_interview;

import java.util.HashMap;
import java.util.Map;

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            if(ptr.children.containsKey(word.charAt(i))){
                ptr = ptr.children.get(word.charAt(i));
            }else{
                ptr.children.put(word.charAt(i), new TrieNode());
                ptr = ptr.children.get(word.charAt(i));
            }
        }
        ptr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            if(ptr.children.containsKey(word.charAt(i))){
                ptr = ptr.children.get(word.charAt(i));
            }else{
                return false;
            }
        }
        
        return ptr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i=0;i<prefix.length();i++){
            if(ptr.children.containsKey(prefix.charAt(i))){
                ptr = ptr.children.get(prefix.charAt(i));
            }else{
                return false;
            }
        }
        
        return true;
    }
    
}
class TrieNode{
    boolean isWord;
    Map<Character, TrieNode> children;
    public TrieNode(){
        children = new HashMap();
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
