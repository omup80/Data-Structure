package top_questions.hard.array_and_string;
//https://leetcode.com/problems/first-missing-positive/
class FindFirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(nums[i]<=0 || nums[i]>nums.length)
                nums[i] = Integer.MAX_VALUE;
          
        for(int num:nums){
            int index = Math.abs(num)-1; 
            if(index<nums.length)
                nums[index]=nums[index]<0?nums[index]:-nums[index];
        
        }
         
            
        
        for(int i=0;i<nums.length;i++)
            if(nums[i]>0)
                return i+1;
        return nums.length+1;
        
    }
}