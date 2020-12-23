package top_questions.medium.string_and_array;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/missing-ranges/
class FindMissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> ranges = new ArrayList<String>();
        if(nums.length==0){
            if(lower==upper)
                ranges.add(""+lower);
            else
                ranges.add(""+lower+"->"+upper);
            
            return ranges;
        }
            
        
        if(nums[0]-lower>=1){
            if(nums[0]-lower==1)
                ranges.add(""+lower);
            else
                ranges.add(""+lower+"->"+(nums[0]-1));
        }
            
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>=2)
                ranges.add(getRange(nums[i+1], nums[i]));
            
            
        }
        int last = nums[nums.length-1];
        if(upper-last>=1){
            if(upper-last==1)
                ranges.add(""+upper);
            else
                ranges.add(""+(last+1)+"->"+upper);
        }
        
        return ranges;
    }
    
    private String getRange(int upper, int num){
        if(upper-num==2)
            return ""+(num+1);
        
        return ""+(num+1)+"->"+(upper-1);
    }
}