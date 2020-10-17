package amazon_questions.mock.telephonic_interview;

import java.util.ArrayList;
import java.util.List;

class Permute {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList();
       List<Integer> comb = new ArrayList();
        
       for(Integer num: nums){
           comb.add(num);
           dfs(nums, comb, result);
           comb.remove(num);
       } 
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> comb, List<List<Integer>> result){
        if(comb.size()==nums.length){
            result.add(new ArrayList<Integer>(comb));
            return ;
        }
            
        for(Integer num: nums){
            if(!comb.contains(num)){
                comb.add(num);
                dfs(nums, comb, result);
                comb.remove(num);
            }
        }
        
    }
}