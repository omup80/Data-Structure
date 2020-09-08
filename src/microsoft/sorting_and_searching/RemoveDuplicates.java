package microsoft.sorting_and_searching;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//26. Remove Duplicates from Sorted Array
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
       int index=1;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[index]=nums[i+1];
                index++;
            }
        }
        
        return index;
        
        
    }
}