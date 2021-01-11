package top_questions.hard.trees;

import java.util.*;
//https://leetcode.com/problems/alien-dictionary/
class AlienOrder {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap();
        Map<Character, Integer> indeg= new HashMap<Character, Integer>();
        
        //initialize graph, indegree
        for(String word: words){
            for(char ch: word.toCharArray()){
                map.putIfAbsent(ch, new ArrayList<Character>());
                indeg.putIfAbsent(ch, 0);
            }
        }
        
        //make graph relationship && set indegree values
        
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";
            
            for(int j=0;j<Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    char first = word1.charAt(j);
                    char second = word2.charAt(j);
                    indeg.put(second, indeg.get(second)+1);
                    List<Character> children = map.get(first);
                    children.add(second);
                    map.put(first, children);
                    break;
                }
                
                
            }
            
            
        }
        Queue<Character> q = new LinkedList<Character>();
        for(Map.Entry<Character,Integer> e: indeg.entrySet()){
            if(e.getValue()==0)
                q.add(e.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char parent = q.remove();
            sb.append(parent);
            for(char child: map.get(parent)){
                int count = indeg.get(child)-1;
                indeg.put(child, count);
                if(count==0)
                    q.add(child);
            }
        }
        
        if(sb.length()<indeg.size())
            return "";
        
        return sb.toString();
    }
}