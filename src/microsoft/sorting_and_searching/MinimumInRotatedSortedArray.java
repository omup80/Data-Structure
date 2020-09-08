package microsoft.sorting_and_searching;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
//153. Find Minimum in Rotated Sorted Array
class MinimumInRotatedSortedArray {
    
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        
        int left=0;
        int right=nums.length-1;
        
        while(left<=right){
            
            int mid=(left+right)/2;
            
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid-1]>nums[mid])
                return nums[mid];
            
             if(nums[mid]>nums[left]){
                 
                 left = mid+1;
             }else{
                 right = mid-1;
             }   
        }
        return -1;
    }
}