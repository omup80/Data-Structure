package top_questions.medium.dynamic_programming;
//https://leetcode.com/problems/jump-game/
class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length<=1)
            return true;
        
        int i=1;
        int val = nums[0];
        while(i<nums.length){
            if(val==0)
                return false;
            else if(nums[i]>=val){
                val=nums[i];
            }else{
                val--;
            }
            i++;
        }
        
        return true;
    }
}