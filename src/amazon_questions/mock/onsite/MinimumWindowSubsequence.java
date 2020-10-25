package amazon_questions.mock.onsite;

class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int j=0,k=0;
        String result=null;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        while(j<s.length){
            if(s[j]==t[k]){
                
                if(k==t.length-1){
                    int end = j+1;
                    while(j>=0 && k>=0){
                         if(s[j]==t[k])
                             k--;
                         j--;
                     }
                
                    j++;
                    if(result==null || end-j<result.length())
                        result=S.substring(j, end);
                    
                    j+=2;

                }
                k++;
                
            }
              j++;    
            
            
        }
        
        return result==null?"":result;
        
        
    }
}