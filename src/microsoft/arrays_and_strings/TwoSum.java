package microsoft.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;
//1. Two Sum
//https://leetcode.com/problems/two-sum/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        
        return new int[2];
        
    }
}