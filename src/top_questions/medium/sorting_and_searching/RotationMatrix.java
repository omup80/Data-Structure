package top_questions.medium.sorting_and_searching;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
class RotationMatrix {
    public int search(int[] nums, int target) {
        
        if(nums.length==1){
            if(nums[0]==target)
                return 0;
            return -1;
        }
        int l= 0;
        int r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[l]){
                if(target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(target>nums[mid] && target<nums[l]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
                
            
        }
        
        return -1;
    }
}