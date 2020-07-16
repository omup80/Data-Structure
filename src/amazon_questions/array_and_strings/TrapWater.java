package amazon_questions.array_and_strings;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
class TrapWater {
    public int trap(int[] height) {
    
        int left=0, area=0, right=height.length-1;
        int leftMax=0, rightMax=0;
        
        while(left<right){
            if(height[left] < height[right]){
                
                
                if(height[left] >=leftMax)
                    leftMax = height[left];
                else
                    area += leftMax-height[left];
                
                left++;
                    
            }else{
               
                if(height[right]>= rightMax)
                    rightMax = height[right];
                else
                    area += rightMax-height[right];
                
                
                right--;
                
                
            }
            
            
        }
        return area;
        
    }
    
}