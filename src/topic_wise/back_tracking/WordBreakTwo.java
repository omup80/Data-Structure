package topic_wise.back_tracking;

import java.util.*;
//https://leetcode.com/problems/word-break-ii/
//140. Word Break II
class WordBreakTwo {
    Set<String> dict = new HashSet<String>();
    Map<String, List<String>> memo = new HashMap();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
       for(String word: wordDict){
           dict.add(word);
       }
      
       return wordBreakTwo(s);
        
    }
    
    private List<String> wordBreakTwo(String s){
       if(memo.containsKey(s))
           return memo.get(s);
        
        List<String> result = new ArrayList();
        if(dict.contains(s))
            result.add(s);
        
        for(int i=1;i<s.length();i++){
           String left = s.substring(0, i);
           if(dict.contains(left)){
               List<String> subs = wordBreakTwo(s.substring(i));
               for(String sub: subs){
                   result.add(left+ " "+sub);
               }
           }    
           
       } 
       memo.put(s, result);
       return result; 
    }   
}