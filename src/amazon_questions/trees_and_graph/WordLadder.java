package amazon_questions.trees_and_graph;

import javafx.util.Pair;

import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       Map<String, List<String>> allCombination = new HashMap<String, List<String>>();
        
        
        int L = beginWord.length();
        
        for(String word: wordList){
            
            for(int i=0; i< L;i++){
                
                String genericWord = word.substring(0,i) + '*' + word.substring(i+1,L);
                List<String> satisfyGeneric = allCombination.getOrDefault(genericWord, new ArrayList<String>());
                satisfyGeneric.add(word);
                allCombination.put(genericWord, satisfyGeneric);
                
            }
            
        }
        
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        while(!Q.isEmpty()){
            Pair<String, Integer> pair = Q.remove();
            String word = pair.getKey();
            int level = pair.getValue();
        
            for(int i=0;i<L;i++){
                String genericWord = word.substring(0,i) + '*' + word.substring(i+1,L);
                List<String> satisfyGenericWord = allCombination.getOrDefault(genericWord, new ArrayList<String>());
                for(String w: satisfyGenericWord){
                    if(endWord.equals(w))
                            return level + 1;
                    
                    if(!visited.getOrDefault(w,false)){
                        visited.put(w, true);
                         Q.add(new Pair(w, level+1));
                    }
                    
                }
                
            }
            
        }
        
    return 0;
        
        
        
        
        
        
    }
}