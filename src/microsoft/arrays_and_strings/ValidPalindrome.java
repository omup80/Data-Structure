package microsoft.arrays_and_strings;
//https://leetcode.com/problems/valid-palindrome/
//125. Valid Palindrome
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        if(s==null || s.length()<=1 || s.trim()=="")
            return true;
        int i=0;
        int j=s.length()-1;
        s = s.toLowerCase();
        
        while(i<j){
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i)) ){
                i++;
            }
            
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))  ){
                j--;
            }
            
            if(j<=i)
                return true;
            
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}