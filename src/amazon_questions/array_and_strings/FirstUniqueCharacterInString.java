package amazon_questions.array_and_strings;

import java.util.Arrays;
/*
Given a string, find the first non-repeating character in it and
return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 */
class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int [] index = new int[26];
        Arrays.fill(index, -2);
        
        for(int i=0;i<s.length();i++){
            int charIndex = s.charAt(i)-'a'; 
            if( index[charIndex] == -2 || index[charIndex] >= 0){
                if(index[charIndex] == -2){
                    index[charIndex] = i;
                }else{
                    index[charIndex] = -1;
                }
            }
        }
        
        int minIndex = -1;
        
        for(int i=0;i<26;i++){
            if(index[i] >=0){
                if(minIndex == -1){
                    minIndex = index[i];
                }else if(index[i] < minIndex){
                    minIndex = index[i];
                }
                    
            }
        }
        
        return minIndex;
    }
}