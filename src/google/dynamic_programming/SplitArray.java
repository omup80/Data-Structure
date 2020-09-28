package google.dynamic_programming;
//https://leetcode.com/problems/split-array-largest-sum/
//410. Split Array Largest Sum

class SplitArray {
    public int splitArray(int[] nums, int m) {
      int left=0;
      int right=0;
      for(int num:nums){
        left = Math.max(left, num);
        right += num; 
      }
        
      while(left<right){
          int mid = left+(right-left)/2;
          int count = split(nums, mid);
          if(count>m){
              left=mid+1;
          }else{
              right=mid;
          }
      }
        
      return left;   
    }     
     private int split(int[] nums, int mid){
         int count=1;
         int sum=0;
         
         for(int num:nums){
             
             if(num+sum>mid){
                 count++;
                 sum=num;
             }else{
                 sum+=num;
             }
             
         }
         
         return count;
     }   
    
}