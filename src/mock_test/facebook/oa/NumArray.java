package mock_test.facebook.oa;
//https://leetcode.com/problems/range-sum-query-immutable/
class NumArray {
    int[] nums;
    int[] sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        int curSum = 0;
        for(int i=0;i<nums.length;i++){
            curSum += nums[i];
            sum[i] = curSum;
        }
    }
    
    public int sumRange(int i, int j) {
        int preSum = i==0?0:sum[i-1];
        int postSum = sum[j];
        return postSum-preSum;
    }
}