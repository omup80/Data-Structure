package microsoft.arrays_and_strings;
//186. Reverse Words in a String II
//https://leetcode.com/problems/reverse-words-in-a-string-ii/
class ReverseStringInWordTwo {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int i=0;
        while(i<s.length){
            if(s[i]==' ')
                i++;
            
            int j=i;
            while(j<s.length && s[j]!=' '){
                j++;
            }
            
            j--;
            reverse(s,i,j);
            i=j+2;
        }
        
    }
    
    private  void reverse(char[] s , int i, int j){
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j]=temp;
            i++;
            j--;
        }
        
    }
}