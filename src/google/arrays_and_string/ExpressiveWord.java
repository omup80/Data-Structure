package google.arrays_and_string;
//https://leetcode.com/problems/expressive-words/
//809. Expressive Words
class ExpressiveWord {
    public int expressiveWords(String S, String[] words) {
     int count=0;
     
      for(String word:words){
          if(canExpandable(S, word))
              count++;
      }    
      return count;  
        
    }
    private boolean canExpandable(String s, String word){
       int sI=0, sJ=0, wI=0, wJ=0;
       int sG=0, wG=0; 
       while(sJ<s.length() && wJ<word.length()){
           if(s.charAt(sI)!=word.charAt(wI))
               return false;
           while(sJ<s.length() && s.charAt(sI)==s.charAt(sJ))
               sJ++;
           
           while(wJ<word.length() && word.charAt(wI)==word.charAt(wJ))
               wJ++;
           sG = sJ-sI;
           wG = wJ-wI;
           if( sG!=wG && sG < Math.max(3, wG)){
               return false;
           }
              // return false;
           sI = sJ;
           wI = wJ;
       }
       if(sJ< s.length() || wJ<word.length())
           return false;
       return true; 
        
    }
}