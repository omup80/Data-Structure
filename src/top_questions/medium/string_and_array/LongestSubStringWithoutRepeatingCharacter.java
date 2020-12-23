package top_questions.medium.string_and_array;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubStringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0;
        Set<Character> set = new HashSet<Character>();
        int longest=0;
        while(r<s.length()){
            while(r<s.length() && !set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            if(r-l > longest)
                longest = r-l;

            
            if(r!=s.length()){
                 while(l<r && s.charAt(l)!=s.charAt(r)){
                      set.remove(s.charAt(l));
                      l++;
                 }
                set.remove(s.charAt(l));
                l++;
            }
            
                
            
            
        }
        
        return longest;
    }
}