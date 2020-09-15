package microsoft.design;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/implement-trie-prefix-tree/
//208. Implement Trie (Prefix Tree)
class Trie {
     class TrieNode{
         boolean isWord;
         Map<Character, TrieNode> neighbours = new HashMap<>();
     }
    
     TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = cur.neighbours.get(ch);
            if(node==null){
                node = new TrieNode();
                cur.neighbours.put(ch, node);
            }
            cur = node;
            if(i==word.length()-1){
                cur.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = cur.neighbours.get(ch);
            if(node==null){
                return false;
            }
            cur = node;
                   
        }   
       return cur.isWord;  
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            TrieNode node = cur.neighbours.get(ch);
            if(node==null){
                return false;
            }
            cur = node;
                   
        }   
       return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */