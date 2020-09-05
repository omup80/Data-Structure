package microsoft.arrays_and_strings;
//https://leetcode.com/problems/trapping-rain-water/
//42. Trapping Rain Water
class TrappingRainWater {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        
       int leftMax=0;
       int rightMax=0;
       int result=0; 
        while(left<right){
            if(height[left]>leftMax)
                leftMax=height[left];
            if(height[right]>rightMax)
                rightMax = height[right];
            if(leftMax<rightMax){
                result += leftMax-height[left];
                left++;
            }else{
                result += rightMax-height[right];
                right--;    
            }
                
            
            
        }
        return result;
        
    }
}