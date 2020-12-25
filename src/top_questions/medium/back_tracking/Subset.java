package top_questions.medium.back_tracking;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/subsets/
class Subset {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList();
      createSubset(0, nums, result, new ArrayList<Integer>());
        return result;
    }
    
    private void createSubset(int index, int[] nums, List<List<Integer>> result, List<Integer> subset){
        
        
        result.add(new ArrayList<Integer>(subset));
        if(index==nums.length)
            return;
        for(int i=index;i<nums.length;i++){
            subset.add(nums[i]);
            createSubset(i+1, nums, result, subset);
            subset.remove(subset.size()-1);
            
        }
        
    }
}