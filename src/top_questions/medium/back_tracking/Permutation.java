package top_questions.medium.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/permutations/
class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        permutation(0, nums, result, new ArrayList<Integer>(), new HashSet<Integer>());
        return result;
    }
    
    private void permutation(int i, int[] nums, List<List<Integer>> result, List<Integer> combination, Set<Integer> set){
        if(i==nums.length){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
                combination.add(num);
                permutation(i+1, nums, result, combination, set);
                set.remove(num);
                combination.remove(combination.size()-1);
            }
        }
        
        
    }
}