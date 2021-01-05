package top_questions.hard.array_and_string;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-consecutive-sequence/
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums)
            set.add(num);
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int curNum = nums[i];
                int curLen=0;
                while(set.contains(curNum)){
                    curNum++;
                    curLen++;
                }
            maxLength = Math.max(curLen, maxLength);    
           }
            
        }
        return maxLength;
    }
}