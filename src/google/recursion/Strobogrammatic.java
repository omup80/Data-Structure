package google.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/strobogrammatic-number-ii/
//247. Strobogrammatic Number II
class Strobogrammatic {
    
    
    public List<String> findStrobogrammatic(int n) {
       List<String> result, ans;
       result =  n%2==0 ? new ArrayList(Arrays.asList("")):new ArrayList(Arrays.asList("0","1","8"));
       if(n<2)
           return result;
        
        for(;n>1;n=n-2){
            ans = new ArrayList<String>();
            for(String i: result){
               if(n>3) 
                    ans.add("0"+i+"0");
                ans.add("1"+i+"1");
                ans.add("8"+i+"8");
                ans.add("6"+i+"9");
                ans.add("9"+i+"6");    
            }
            result = ans;
            
        }
        
        return result;
        
    }
    
    
}