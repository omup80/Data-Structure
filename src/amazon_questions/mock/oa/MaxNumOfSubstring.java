package amazon_questions.mock.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/submissions/
//1520. Maximum Number of Non-Overlapping Substrings

class MaxNumOfSubstring {
    Map<Character, Integer[]> map=new HashMap();
    public List<String> maxNumOfSubstrings(String s) {
        
       for(int i=0;i<s.length();i++){
           if(map.containsKey(s.charAt(i))){
               Integer[] bound = map.get(s.charAt(i));
               bound[1]=i;
               map.put(s.charAt(i), bound);
               
           }else{
               Integer[] bound  = new Integer[2];
               bound[0]=bound[1]=i;
               map.put(s.charAt(i), bound);
           }
           
       }
        
      List<String> result = new ArrayList();
      int right=-1;  
      for(int i=0;i<s.length();i++){
          char ch = s.charAt(i);
          Integer[] bound = map.get(ch);
          if(bound[0]==i){
              int newRight = rightPart(ch, s, bound);
              if(newRight!=-1){
                if(i>right)
                  result.add("");
               right = newRight;
               result.set(result.size()-1, s.substring(i, right+1));    
              }
              
              
          }
      }
        

        return result;   
    }
    
    private int rightPart(char ch, String s, Integer[] bound){
      int right=bound[1];  
      for(int i=bound[0];i<right;i++){
          Integer[] cBound = map.get(s.charAt(i));
          if(cBound[0]<bound[0])
              return -1;
          right = Math.max(right, cBound[1]);
               
      }
        
     return right;   
        
    }
}