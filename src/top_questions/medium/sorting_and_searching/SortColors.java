package top_questions.medium.sorting_and_searching;
//https://leetcode.com/problems/sort-colors/
class SortColors {
    public void sortColors(int[] nums) {
        int left=0, idx=0, right=nums.length-1;
        
        while(idx<=right){
            if(nums[idx]==0){
                swap(left, idx, nums);
                left++;
                idx++;
            }else if(nums[idx]==2){
                swap(idx, right, nums);
                
                right--;
            }else{
                idx++;
            }
            
            
        }
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}