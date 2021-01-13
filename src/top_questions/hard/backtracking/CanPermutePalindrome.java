package top_questions.hard.backtracking;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/palindrome-permutation/
class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            int count = map.getOrDefault(c, 0);
            if(count==0)
                map.put(c, count+1);
            else
                map.put(c, count-1);
        }
        
        int oddCount=0;
        for(Integer value: map.values())
            oddCount+=value;
       return oddCount<=1;
    }
}