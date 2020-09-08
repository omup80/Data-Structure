package microsoft.sorting_and_searching;
//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        
        if(nums.length==1 && nums[0]!=target){
            return -1;
        }else if(nums.length==1 && nums[0]==target){
            return 0;
        }
        
        int pivot = getMinInArray(nums);
       return target >= nums[pivot] && target<= nums[nums.length-1]?bs(nums,target,pivot, nums.length-1):bs(nums,target, 0, pivot-1); 
        
    }
    private int bs(int[] nums,int target, int left, int right){
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
                
        }
        return -1;
    }
    private int getMinInArray(int[] nums){
        int left=0;
        int right=nums.length-1;
        if(nums[left]<nums[right])
            return left;
        
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(nums[mid]>nums[mid+1])
                return mid+1;
            if(nums[mid-1]>nums[mid])
                return mid;
            
            if(nums[left]<nums[mid]){
                left=mid+1;
            }else{
                right = mid-1;
            }
            
            
        }
        
        return -1;
    }
}