package microsoft.arrays_and_strings;
//https://leetcode.com/problems/longest-palindromic-substring/submissions/
//5. Longest Palindromic Substring
class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;
        
        
        int start =0;
        int end=0;
        int length=0; 
        for(int i=0;i<s.length();i++){
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i+1);
            int l = Math.max(l1,l2);
            //aba i=1 l=3 start = 1-1=0 end = 1+1
            //abba i=1 l=4 start = 1-2=0 end = 1+2   
            if(l>length){
                length=l;
                start= l%2==0?i-l/2+1:i-l/2;
                end = i+l/2;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    private int expand(String s, int l, int r){
       while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
           l--;
           r++;
       }
        
      return r-l-1;   
    }
}