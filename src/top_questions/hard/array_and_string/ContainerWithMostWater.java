package top_questions.hard.array_and_string;
//https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max=0;
        int i=0;
        int j = height.length-1;
        while(i<j){
            max = Math.max((j-i)* Math.min(height[i],height[j]), max);
            if(height[i]>height[j])
                   j--;
            else
                i++;           
            
            
        }
        return max;                   
    }
}