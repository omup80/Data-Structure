package top_questions.hard.array_and_string;
//https://leetcode.com/problems/product-of-array-except-self/
class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] l  = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = 1;
        r[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++)
            l[i] = l[i-1]*nums[i-1];
        
        for(int i=nums.length-2;i>=0;i--)
            r[i] = r[i+1]*nums[i+1];
        
        int[] result = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            result[i] = r[i] * l[i];
        }
        return result;
    }
}