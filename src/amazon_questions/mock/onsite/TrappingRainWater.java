package amazon_questions.mock.onsite;

class TrappingRainWater {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int result=0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[height.length-1] = height[height.length-1];
        
        for(int i=height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        
        for(int i=1;i<height.length-1;i++){
            result += Math.min(left[i], right[i]) - height[i];
        }
        
        return result;
    }
}