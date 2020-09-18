package google.others;

import java.util.HashMap;
import java.util.Map;

//205. Isomorphic Strings
//https://leetcode.com/problems/isomorphic-strings/
class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<Character, Character>();
        if(s.length()!=t.length())
            return false;
        
        for(int i=0;i<s.length();i++){
            if(!mapping.containsKey(s.charAt(i))){
                if(mapping.containsValue(t.charAt(i)))
                    return false;
                
                mapping.put(s.charAt(i), t.charAt(i));
            }else{
                
                if(mapping.get(s.charAt(i))!= t.charAt(i))
                    return false;
            }
            
        }
        
        return true;
       
    }
}