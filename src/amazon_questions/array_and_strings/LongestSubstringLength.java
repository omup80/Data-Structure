package amazon_questions.array_and_strings;

import java.util.HashSet;

class LongestSubstringLength {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int i=0,j=0;
        HashSet<Character> str = new HashSet<Character>();
        while(j<s.length()){
            char c = s.charAt(j);
            if(!str.contains(c)){
                str.add(c);
                maxLength = Math.max(maxLength, str.size());
                j++;
            }else{
                while(s.charAt(i) != c){
                    str.remove(s.charAt(i));
                    i++;    
                }
                str.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}