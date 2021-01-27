package mock_test.facebook.oa;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
class MaxArrayLength {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum=0;
        int maxLength=0;
        
        for(int i=0;i<nums.length;i++){
           sum += nums[i];
            
           if(sum==k)
               maxLength=i+1;
            
            
            if(!map.containsKey(sum))
                map.put(sum, i);
            
            
            if(map.containsKey(sum-k)){
                if(i-map.get(sum-k)>maxLength)
                    maxLength=i-map.get(sum-k);
            }
            
            
            
        }
        
        return maxLength;
        
        
        
    }
}