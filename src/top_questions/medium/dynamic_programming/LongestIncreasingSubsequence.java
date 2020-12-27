package top_questions.medium.dynamic_programming;
//https://leetcode.com/problems/longest-increasing-subsequence/
class LongestIncreasingSubsequence {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length+1][nums.length];
        
        return findLongestSequence(0, nums, -1);
    }
    
    private int findLongestSequence(int index, int[] nums, int lastIndex){
        if(index==nums.length)
            return 0;
        
        
        if(dp[lastIndex+1][index] != null)
            return dp[lastIndex+1][index];
        
        int inc=Integer.MIN_VALUE;
        if(lastIndex<0 || nums[index]>nums[lastIndex])
            inc = 1 + findLongestSequence(index+1, nums, index);
        
        int exc = findLongestSequence(index+1, nums, lastIndex);
        return dp[lastIndex+1][index]=Math.max(inc, exc);
        
    }
}