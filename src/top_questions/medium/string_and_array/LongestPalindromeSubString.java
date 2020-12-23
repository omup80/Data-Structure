package top_questions.medium.string_and_array;
//https://leetcode.com/problems/longest-palindromic-substring/
class LongestPalindromeSubString {
    String result="";
    public String longestPalindrome(String s) {

        for(int i=0;i<s.length();i++){
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }
        return result;
    }
    
    private void checkPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        i++;
        j--;
        
        if(j-i+1>result.length()){
            
            result=s.substring(i, j+1);
        }
            
            
    }
}