package google.arrays_and_string;
//55. Jump Game
//https://leetcode.com/problems/jump-game/
class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        int maxJumpRequired=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=maxJumpRequired){
                maxJumpRequired=1;
            }else{
                maxJumpRequired++;
            }
            
        }
        return nums[0]>=maxJumpRequired?true:false;
    }
}