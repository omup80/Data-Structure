package amazon_questions.array_and_strings;
import java.util.Arrays;
class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum=0;
        int absMin = minDistance;
        for(int i=0;i<nums.length-2;i++){
            
            if(i==0|| (i>0 && nums[i]!=nums[i-1])){
               int low = i+1;
               int high = nums.length-1;
                
                while(low<high){
                    
                    sum = nums[low]+nums[high]+nums[i];
                    if(sum==target)
                        return sum;
                    
                    if(Math.abs(target-sum) < absMin){
                        minDistance = target-sum;
                        absMin = Math.abs(minDistance);
                    }
                    
                    
                    if(sum<target){
                        low++;
                    }else if(sum>target){
                        high--;
                    }
                        
                        
                    
                }
                
                
            }
            
            
        }
        
       return target-minDistance;
        
    }
}