package amazon_questions.mock.telephonic_interview;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dic = new HashSet();
        int i=0,j=0;
        int max=0;
        while(i<s.length() && j<s.length()){
            if(!dic.contains(s.charAt(j))){
                dic.add(s.charAt(j));
                max=Math.max(dic.size(), max);
                j++;
            }else{
                char ch = s.charAt(j);
                while(s.charAt(i)!=ch){
                    dic.remove(s.charAt(i));
                    i++;
                }
                i++;
                dic.remove(ch);
            }
        }
        
        return max;
    }
}