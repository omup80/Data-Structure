package topic_wise.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/permutations/
//46. Permutations
class Permute {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        
        dfs(nums, new HashSet<Integer>(), new ArrayList<Integer>());   
        
        return result;
        
    }
    
    private void dfs(int[] nums, Set<Integer> visited, List<Integer> ans){
        
        
        if(ans.size()== nums.length){
            result.add(new ArrayList<Integer>(ans));
        }
        
        for(int num: nums){
            
            if(!visited.contains(num)){
               visited.add(num);
               ans.add(num);
               dfs(nums, visited, ans);
               visited.remove(num);
               ans.remove(ans.size()-1); 
            }
            
        }
        
    }
}