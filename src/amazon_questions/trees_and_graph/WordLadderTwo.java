package amazon_questions.trees_and_graph;

import java.util.*;

class WordLadderTwo {
   
        
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
     
     List<List<String>> result = new ArrayList<List<String>>();
     Map<String,List<String>> graph = buildGraph(beginWord, endWord, new HashSet<>(wordList));
     List<String> path = new ArrayList<>();
     dfsForPath(graph, beginWord, endWord, path, result);
      return result;
    
    }
 
   private Map<String,List<String>> buildGraph(String beginWord, String endWord, Set<String> wordList){
        Map<String,List<String>> graph = new HashMap<>();
       
        Set<String> visited = new HashSet<>();
        Set<String> toVisit = new HashSet<String>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        toVisit.add(beginWord);
        boolean isEndWordFound = false;
        
        while(!queue.isEmpty()){
            
            visited.addAll(toVisit);
            toVisit.clear();
            int size = queue.size();
            
            
            for(int i=0;i<size;i++){
                String word = queue.remove();
                List<String> next = getNext(word, wordList);        
            
                for(String newWord: next){
                    
                    if(newWord.equals(endWord))
                        isEndWordFound = true;
                    
                    if(!visited.contains(newWord)){
                        
                        List<String> neighbours = graph.getOrDefault(word, new ArrayList<String>());
                        neighbours.add(newWord);
                        graph.put(word, neighbours);
                    }
                    if (!visited.contains(newWord) && !toVisit.contains(newWord)) {
                        queue.add(newWord);
                        toVisit.add(newWord);
                    }
                    
                        
            }
            
                
            }
            if(isEndWordFound)
                break;
                     
        }
       return graph;
        
    }
    
    
    private List<String> getNext(String word, Set<String> wordList){
          
         char[] wordLetters = word.toCharArray();
         List<String> next = new ArrayList<String>();
        
         for(char i='a';i<'z';i++){
            for(int j=0;j< wordLetters.length;j++){
                if (wordLetters[j] == i) continue;
                char old = wordLetters[j];
                wordLetters[j] = i;
                String w = String.valueOf(wordLetters);
                if(wordList.contains(w) && !next.contains(w)){
                    next.add(w);
                    
                }
                wordLetters[j] = old;
            }
             
         }
        
        return next;
          
        
        
        
    }
    
    private void dfsForPath(Map<String,List<String>>  graph, String curWord, String endWord, List<String> path, List<List<String>> result){
        path.add(curWord);
        
        if (curWord.equals(endWord)) 
            result.add(new ArrayList<String>(path));
        else if (graph.containsKey(curWord)) {
            for (String nextWord : graph.get(curWord)) {
                dfsForPath(graph,nextWord, endWord , path, result);
            }
        }

        path.remove(path.size()-1);
        
        
    }
    
}   