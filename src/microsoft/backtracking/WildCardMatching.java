package microsoft.backtracking;
//https://leetcode.com/problems/wildcard-matching/
//44. Wildcard Matching
class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int starPtr=-1;
        int sTempPtr=-1;
        int sPtr=0;
        int pPtr=0;
        
        
        while(sPtr<sLen){
            
            if(pPtr< pLen && (s.charAt(sPtr)==p.charAt(pPtr)|| p.charAt(pPtr)=='?')){
                sPtr++;
                pPtr++;
            }else if(pPtr< pLen && p.charAt(pPtr)=='*'){
                sTempPtr=sPtr;
                starPtr = pPtr;
                pPtr++;
            }else if(starPtr==-1){
                    return false;
                
            }else{
                
                sPtr= sTempPtr+1;
                pPtr = starPtr+1;
                sTempPtr = sPtr;
            }
            
            
            
        }
        
        while(pPtr<pLen){
            if(p.charAt(pPtr)=='*'){
                pPtr++;
            }else{
                return false;
            }
        }
        
        return true;
    
    
    }
    
    
}


