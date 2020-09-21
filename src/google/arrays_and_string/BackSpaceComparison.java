package google.arrays_and_string;
//844. Backspace String Compare
//https://leetcode.com/problems/backspace-string-compare/
class BackSpaceComparison {
    public boolean backspaceCompare(String S, String T) {
        return getFinalString(S).equals(getFinalString(T));
        
    }
    private String getFinalString(String s){
        StringBuffer b = new StringBuffer(s);
        int i=0;
        while(i>=0 && i<b.length()){
            if(i+1<b.length() && b.charAt(i)!='#' && b.charAt(i+1)=='#'){
              b = b.deleteCharAt(i);
              b = b.deleteCharAt(i); 
              i--;
              if(i==-1)
                  i++;
            }else{
                i++;
            }
            
        }
        
        return b.toString().replace("#","");
        
        
    }
}