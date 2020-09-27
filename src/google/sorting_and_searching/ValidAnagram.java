package google.sorting_and_searching;
//https://leetcode.com/problems/valid-anagram/
//242. Valid Anagram
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if((s==null && t==null) || (s.length()==0 && t.length()==0))
            return true;
        if(s==null || t==null || s.length()!=t.length())
            return false;
        
        int[] countS = new int[26];
        int[] countT = new int[26];
        
        for(int i=0;i<s.length();i++){
            countS[s.charAt(i)-'a'] +=1;
            countT[t.charAt(i)-'a'] +=1;
        }
        
        for(int i=0;i<26;i++){
            if(countS[i]!=countT[i])
                return false;
        }
        
        return true;
    }
}