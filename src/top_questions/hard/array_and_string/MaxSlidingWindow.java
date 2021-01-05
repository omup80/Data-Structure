package top_questions.hard.array_and_string;

import java.util.ArrayDeque;
//https://leetcode.com/problems/sliding-window-maximum/
class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length * k==0)
            return new int[0];
        if(k==1)
            return nums;
            
        int[] result = new int[nums.length-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i=0;i<k;i++){
            cleanDeque(dq, i, k, nums);
            dq.addLast(i);
            
        }
        int j=0;
        result[j++] = nums[dq.getFirst()];
        
        for(int i=k;i<nums.length;i++){
            cleanDeque(dq, i, k, nums);
            dq.addLast(i);
            result[j++] = nums[dq.getFirst()];
        }
        return result;
    }
    public void cleanDeque(ArrayDeque<Integer> dq, int i, int k, int[] nums){
        
        if(!dq.isEmpty() && i-dq.peekFirst()==k)
            dq.removeFirst();
        
        while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()])
            dq.removeLast();
        
    }
}