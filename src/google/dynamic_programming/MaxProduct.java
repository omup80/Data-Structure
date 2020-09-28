package google.dynamic_programming;
//https://leetcode.com/problems/maximum-product-subarray/
//152. Maximum Product Subarray
class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int cur, minSoFar, maxSoFar, result;
         cur = minSoFar= maxSoFar= result= nums[0];
        
        for(int i=1;i<nums.length;i++){
            
            cur = nums[i];
            
            int temp = Math.max(cur, Math.max(cur * maxSoFar, cur* minSoFar));
            minSoFar = Math.min(cur, Math.min(cur * maxSoFar, cur* minSoFar));
            maxSoFar = temp;
            result = Math.max(maxSoFar, result);
            
        }
        
        return result;
    }
    
}