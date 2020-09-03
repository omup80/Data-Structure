package microsoft.arrays_and_strings;
//https://leetcode.com/problems/reverse-words-in-a-string/submissions/
//151. Reverse Words in a String
class ReverseWord {
    
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            int j=i;
            while(j>=0 && s.charAt(j)!=' '){
                j--;
            }
            
            reverse.append(s.substring(j+1,i+1)).append(" ");
            i=j;
        }
        
        return reverse.toString().trim();
        
    }
    
    
    
    
}