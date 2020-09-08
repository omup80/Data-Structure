package microsoft.sorting_and_searching;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
//154. Find Minimum in Rotated Sorted Array II
class MinimumSortedArrayTwo {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]<nums[high]){
                high=mid;
            }else if(nums[mid]> nums[high]){
                low=mid+1;
            }else{
                high--;
            }
            
            
        }
        return nums[low];
    }
}