package amazon_questions.array_and_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
       
        Arrays.sort(nums);
        
        List<List<Integer>> sumOfThree = new ArrayList<List<Integer>>();
        
        
        for(int i=0;i<nums.length-2;i++){
            if(i==0|| (i>0 && nums[i]!=nums[i-1])){
               int low = i+1;
               int high = nums.length-1;
                
                while(low<high){
                    if(nums[low]+nums[high]== -nums[i]){
                        sumOfThree.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        while(low<high && nums[low]==nums[low+1]){
                            low++;
                        }
                        
                        while(low<high && nums[high]==nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    
                    }else if(nums[low]+nums[high] > -nums[i]){
                        high--;
                    }else{
                        low++;
                    }
                    
                    
                }
                
                
            }
            
            
        }
        
       return sumOfThree;
       
    }
}