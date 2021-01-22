package mock_test.facebook.oa;
//https://leetcode.com/problems/squares-of-a-sorted-array/
class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int j=0;
        int n=nums.length;
        while(j<n && nums[j]<0)
            j++;
        j=j-1;
        int i=j+1;
        int[] result = new int[n];
        int k=0;
        while(j>=0 && i<n){
            if(nums[j]*nums[j] < nums[i]*nums[i]){
                result[k] = nums[j]*nums[j];
                j--;
            }else{
                result[k] = nums[i]*nums[i];
                i++;
            }
            k++;
                
        }
        if(j>=0){
            while(j>=0){
                result[k] = nums[j] *nums[j];
                j--;
                k++;
            }
        }
        
        if(i<n){
            while(i<n){
                result[k] = nums[i] *nums[i];
                i++;
                k++;
            }
        }
        
        return result;
    }
}