package top_questions.hard.array_and_string;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
class LongestSubStringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i=0, j=0;
        int result=0;
        while(j<s.length()){
            
            while(j<s.length() && map.size()<=k){
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                
                j++;
            }
            result = map.size()>k?Math.max(j-i-1, result): Math.max(j-i, result);
            while(i<s.length() && map.size()>k){
                char ch = s.charAt(i);
                int count = map.get(ch);
                if(count==1)
                    map.remove(ch);
                else
                    map.put(ch, count-1);
                i++;
                
            }
            
            
        }
        return result;
    }
}