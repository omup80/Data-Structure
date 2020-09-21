package google.arrays_and_string;
//https://leetcode.com/problems/next-permutation/
//31. Next Permutation
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        if(i>=0){
            int j = nums.length-1;
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
            reverse(nums,i+1);
        }
        if(i<0)
            reverse(nums,0);
    }
    public void reverse(int[] nums, int i){
          int j = nums.length-1;
          while(i<j){
              swap(nums,i,j);
              i++;
              j--;
          }
    }
    
    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}