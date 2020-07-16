package practise.arrays;
/*

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSum {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int currentSum = nums[0];

            for(int i=1; i< nums.length; i++){
                currentSum = Math.max(currentSum + nums[i], nums[i]);
                maxSum = Math.max(maxSum, currentSum);

            }

            return maxSum;


        }

}
