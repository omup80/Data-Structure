package google.arrays_and_string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/missing-ranges/submissions/
//163. Missing Ranges
//
class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int i=lower;
        int j=0;
        List<String> result = new ArrayList<String>();
        
        while(j<nums.length&& i<=upper){
            
            if(j<nums.length && i<nums[j]){
                String range = nums[j]-i==1?""+i:""+i+"->"+(nums[j]-1);
                result.add(range);
                i = nums[j];
                
            }
            
           j++;
           i++;
        }
        if(i<=upper){
            String range = upper-i==0?""+i:""+i+"->"+(upper);
            result.add(range);
        }
        return result;
    }
}