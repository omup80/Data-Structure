package top_questions.hard.array_and_string;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/4sum-ii/
class FourSumTwo {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count=0;
        
        for(int a: A)
            for(int b: B)
                map.put(a+b, map.getOrDefault(a+b, 0)+1);
            
        
        
        for(int c: C)
            for(int d: D)
                count += map.getOrDefault(-(c+d), 0);
            
        
       return count; 
        
    }
}