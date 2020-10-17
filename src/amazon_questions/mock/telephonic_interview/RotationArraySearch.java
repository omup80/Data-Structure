package amazon_questions.mock.telephonic_interview;

class RotationArraySearch {
    public int search(int[] nums, int target) {
        
        int left=0;
        int right = nums.length-1;
        
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[left]>nums[mid]){
                if(target>=nums[left] || target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }else{
            
                if(target>=nums[left] && target<nums[mid])
                    right = mid-1;
                 else
                     left = mid+1;
            }
                
                
            
        }
        
        
        
            return nums[left]==target?left:-1;
        
    }
}