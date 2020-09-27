package google.sorting_and_searching;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//34. Find First and Last Position of Element in Sorted Array
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        int left=0;
        int right=nums.length-1;
        int mid=0; 
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target)
                break;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left = mid+1;
                
        }
        if(nums[mid]!=target)
            return new int[]{-1,-1};
        
         left=right=mid;
        while(left>=0 && nums[left]==target)
            left--;
        left++;
        
        while(right<nums.length && nums[right]==target)
            right++;
        right--;
        
        return new int[]{left, right};
    }
}