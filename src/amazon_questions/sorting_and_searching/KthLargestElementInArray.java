package amazon_questions.sorting_and_searching;

import java.util.Random;
/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
class KthLargestElementInArray {
    int [] nums;
    public int findKthLargest(int[] nums, int k) {
       
       this.nums = nums;
       return quickSelect(0, nums.length-1, nums.length-k);
        
    }
    
    private int quickSelect(int left, int right, int k_smallest){
        
        
     Random rand = new Random();
     int pivotIndex = left + rand.nextInt(right-left+1);
     
     pivotIndex = partition(left, right, pivotIndex);   
     if(pivotIndex==k_smallest)
         return nums[pivotIndex];
      else if(pivotIndex<k_smallest)
          return quickSelect(pivotIndex+1, right, k_smallest);
      else
          return quickSelect(left, pivotIndex-1, k_smallest);
       
      
        
    }
     
    private int partition(int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        int storeIndex = left;
        swap(pivotIndex, right);
        for(int i=left;i<=right;i++){
            if(nums[i]<pivot && i==storeIndex){
                storeIndex++;
            }else if(nums[i]<pivot){
                swap(storeIndex, i);
                storeIndex++;    
            }    
        }
       
       swap(storeIndex, right);
        
        return storeIndex;
        
        
    }
    
    private void swap(int aIndex, int bIndex){
        int temp = nums[aIndex];
        nums[aIndex] = nums[bIndex];
        nums[bIndex] = temp;
        
    }
}