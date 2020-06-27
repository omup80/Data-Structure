package amazon_questions.array_and_strings;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complement = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            Integer index = complement.get(target-nums[i]);
            if(index==null)
              complement.put(nums[i], i);    
            else
               return new int[]{i, index}; 
            
            
        }
        
        return new int[2];
        
        
    }
}