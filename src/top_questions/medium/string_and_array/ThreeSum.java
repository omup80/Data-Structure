package top_questions.medium.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/3sum/
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        if(nums.length<=2)
            return result;
        
        int i=0;
        
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> ans = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(ans);
                    
                    while(j+1<nums.length-1 && nums[j+1]==nums[j])
                        j++;
                    
                    j++;
                    while(k-1>j && nums[k-1]==nums[k])
                        k--;
                    k--;
                    
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }    
            }
            
            while(i+1<nums.length-2 && nums[i+1]==nums[i])
                        i++;
            i++;
            
        }
        return result;
    }
}