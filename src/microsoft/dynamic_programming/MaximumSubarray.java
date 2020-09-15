package microsoft.dynamic_programming;
//https://leetcode.com/problems/maximum-subarray/
//53. Maximum Subarray
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
                
            }else if(sum+nums[i]<0){
                
                sum=Integer.MIN_VALUE;
                
            }else{
                sum = sum+nums[i];
            }
            
          maxSum = Math.max(sum, maxSum);  
        }
            return maxSum;

    }
}