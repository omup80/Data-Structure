package topic_wise.back_tracking;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    /** Initialize your data structure here. */
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, trie.trieNode);
    }
}


class Trie{
    TrieNode trieNode = new TrieNode();
    public void insert(String word){
        TrieNode root = trieNode;

        for(int i=0;i<word.length();i++){
            if(root.node.containsKey(word.charAt(i))){
                root = root.node.get(word.charAt(i));
            }else{
                root.node.put(word.charAt(i), new TrieNode());
                root = root.node.get(word.charAt(i));
            }
        }

        root.isWord = true;
    }


    public boolean search(String word, TrieNode root){

        if(word.length()==0 && root.isWord)
            return true;
        if(word.length()==0 && !root.isWord)
            return false;

        if(word.charAt(0)!='.'){
            if(root.node.containsKey(word.charAt(0)))
                return search(word.substring(1), root.node.get(word.charAt(0)));
            else
                return false;
        }

        for(Map.Entry<Character,TrieNode> e: root.node.entrySet()){
            if(search(word.substring(1), e.getValue()))
                return true;
        }
        return false;
    }
}

class TrieNode{
    boolean isWord;
    Map<Character, TrieNode> node = new HashMap<Character, TrieNode>();
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */