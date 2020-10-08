package amazon_questions.mock.oa;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap();
        for(int[] p: dominoes){
            
            String key = p[0]<p[1]?p[0]+","+p[1]:p[1]+","+p[0];
                
                if(map.containsKey(key)){
                    int count = map.get(key);
                    
                    map.put(key, count+1);    
                }else{
                   map.put(key, 1);
                }
                
            
        }
        
        int domino = 0;
        for(Map.Entry<String,Integer> e: map.entrySet()){
            if(e.getValue()>1){
                domino=domino+getCombination(e.getValue());
            }
        }    
        return domino;
        
    }
    private int getCombination(int n){
       n = n *(n-1); 
       return n/2;  
    }
}