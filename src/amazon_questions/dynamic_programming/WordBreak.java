package amazon_questions.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
class WordBreak {
    Set<String> dict =new HashSet<String>();
    Boolean [] memo;
    int len;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        memo = new Boolean[s.length()];
        len = s.length();
        for(String word: wordDict){
            dict.add(word);
        }
        
        return wordSearch(s);
    }
    private boolean wordSearch(String s){
        
        if("".equals(s))
            return true;
        
        if(memo[len-s.length()]!=null)
            return memo[len-s.length()];
        
        for(int i=0;i<s.length();i++){
           
            if(dict.contains( s.substring(0,i+1)) && wordSearch(s.substring(i+1))  ){
                memo[len-s.length()] = true;
                return true;
            }
            
        }
        memo[len-s.length()] = false;
        return false;
    }
}