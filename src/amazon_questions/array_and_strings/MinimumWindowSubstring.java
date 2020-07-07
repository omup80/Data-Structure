package amazon_questions.array_and_strings;

import java.util.HashMap;
/*
Given a string S and a string T, find the minimum window in S which will contain all
the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum
window in S.
 */
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCharCount = new HashMap<Character, Integer>();
        
        for(int i=0;i<t.length();i++){
            int count = tCharCount.getOrDefault(t.charAt(i),0);
            tCharCount.put(t.charAt(i), count+1);
        }
        
        int l=0, r=0, reqL=0, reqR=0;
        
        int totalDistinctIncluded=0, distinctCharRequired = tCharCount.size();
        
        int minWindowLength = Integer.MAX_VALUE;
        
        HashMap<Character, Integer> sCharCount = new HashMap<Character, Integer>();
        
        while(r < s.length()){
            
            char c = s.charAt(r);
            int count = sCharCount.getOrDefault(c, 0);
            count++;
            sCharCount.put(c, count);
            
            
            if(tCharCount.containsKey(c) && tCharCount.get(c)==count){
                totalDistinctIncluded++;
                
                if(totalDistinctIncluded == distinctCharRequired){
                   while( totalDistinctIncluded == distinctCharRequired && l<=r ){
                        
                        if(minWindowLength > r-l+1){
                            
                            minWindowLength = r-l+1;
                                reqL = l;
                                reqR = r;
                         
                        }
                        
                        char cl = s.charAt(l);
                        int clCount = sCharCount.get(cl);
                        clCount--;
                        sCharCount.put(cl, clCount);
                        
                        if(tCharCount.containsKey(cl) && clCount < tCharCount.get(cl)){
                            totalDistinctIncluded--;
                        
                        }
                        
                            
                            
                        
                        l++;
                    }
                    
                }
                
                
                
            }
            
            r++;
        
        
        }
       return minWindowLength==Integer.MAX_VALUE ? "": s.substring(reqL, reqR+1);
    }
}