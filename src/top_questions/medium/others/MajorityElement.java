package top_questions.medium.others;

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums)
             map.put(num, map.getOrDefault(num, 0) +1);
        
        int key=-1, value=Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()>value){
                key = e.getKey();
                value = e.getValue();
            }
            
        }
        
        return key;
        
    }
}