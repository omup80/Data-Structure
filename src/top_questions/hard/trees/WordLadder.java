package top_questions.hard.trees;

import java.util.*;
//https://leetcode.com/problems/word-ladder/
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<String>();
        for(String word: wordList)
            dictionary.add(word);
        
        if(!dictionary.contains(endWord))
            return 0;
        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int height=2;
        visited.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String w = q.remove();
                List<String> children = findChildren(w, dictionary);
                for(String child: children){
                    if(child.equals(endWord))
                        return height;
                    else if(!visited.contains(child)){
                        visited.add(child);
                        q.add(child);
                    }
                }
            }
            height++;
        }
        
        return 0;
        
        
    }
    
    public List<String> findChildren(String word, Set<String> dictionary){
        char[] w = word.toCharArray();
        List<String> children = new ArrayList<String>();
        
        for(int i=0;i<w.length;i++){
            char currChar = w[i];
            for(char a='a';a<='z';a++){
                if(currChar!=a){
                    w[i] = a;
                    if(dictionary.contains(String.valueOf(w))){
                        children.add(String.valueOf(w));
                    }
                    w[i]=currChar;
                }
            }
            
            
        }
        return children;
        
        
        
    }
}