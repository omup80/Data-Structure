package google.arrays_and_string;

import java.util.HashSet;
import java.util.Set;

class NextClosestTime {
    public String nextClosestTime(String time) {
        int uL = Integer.MIN_VALUE;
        int lL = Integer.MAX_VALUE;     
        Set<Integer> digits = new HashSet<Integer>();
        int digit;
        
        for(int i=0;i<time.length();i++){
            if(i==2)
                continue;
            digit = time.charAt(i)-'0'; 
            digits.add(digit);
            lL = Math.min(digit, lL);
            uL = Math.max(uL, digit);
            
        }
        StringBuilder result = new StringBuilder();
    
        
        digit = findGreater(digits, time.charAt(4)-'0', lL, uL);
        if(digit!=-1)
           return result.append(time.substring(0,4)).append(digit).toString();
        
         result.append(lL);
         
        
        
        digit = findGreater(digits, time.charAt(3)-'0', lL, 5);
        if(digit!=-1)
           return result.insert(0,digit).insert(0,time.substring(0,3)).toString();
        
        result.insert(0,lL);
          
        result.insert(0,":");
        
        digit = findGreater(digits, time.charAt(1)-'0', lL, time.charAt(0)<'2'?9:4);
        if(digit!=-1)
           return result.insert(0,digit).insert(0,time.substring(0,1)).toString();
        
          result.insert(0,lL);
         
        
        digit = findGreater(digits, time.charAt(0)-'0', 0, 2);
        if(digit!=-1)
           return result.insert(0,digit).toString();
        
        return result.insert(0,lL).toString();
          
        
        
        
    }
    private int findGreater(Set<Integer> digits, int num, int lL, int uL){
        for(Integer digit: digits){
            if(digit>num && digit>lL && digit<=uL)
                return digit;
        }
        return -1;
    }
    
    
}