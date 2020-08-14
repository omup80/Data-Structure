package amazon_questions.sorting_and_searching;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        int pivot = findPivotElementIndex(nums, low, high);
        
        return binarySearch(nums, low, high, pivot, target);
        
        
        
        
    }
    
    private int binarySearch(int [] nums,int low,int high,int pivot,int target){
        if(low>high)
            return -1;
        
      if(pivot!=-1){
        if(nums[pivot]==target)
            return pivot;
        
        if(target>=nums[low] && target<nums[pivot])
            high = pivot-1;
        else
            low = pivot+1;
          
      }  
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(target > nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        
        return -1;
    }
    
    private int findPivotElementIndex(int[] nums, int low, int high){
        
        while(low<=high){
            
            int mid = (low+high)/2;
            
            if(low==high){
                return low;
            }else if(mid<high && nums[mid]>nums[mid+1]){
                return mid;
            }else if(low< mid && nums[mid-1]>nums[mid]){
                return mid-1;
            }else if(low< mid && nums[mid]>nums[mid-1] && nums[mid]>nums[low]){
                
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        return -1;
        
        
    }
}