package google.arrays_and_string;

import java.util.HashMap;
import java.util.Map;

//159. Longest Substring with At Most Two Distinct Characters
//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
class LongestSubstringWithTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxCount=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i=0;
        int j=0;
        int width=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.size() < 2 || map.containsKey(ch)){
                int count = map.getOrDefault(ch, 0)+1;
                map.put(ch, count);
                width++;
                maxCount = Math.max(width, maxCount);
                j++;
            }else{
                
                while(i< s.length() && i<j && map.size()==2){
                    int count = map.get(s.charAt(i))-1;
                    map.put(s.charAt(i), count);
                    
                    if(count==0){
                        map.remove(s.charAt(i));
                        
                    }
                    i++;
                    width--;
                }
                
                
            }
            
        }
        return maxCount;
        
    }
}