package top_questions.medium.string_and_array;
//https://leetcode.com/problems/increasing-triplet-subsequence/
class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int n1=Integer.MAX_VALUE;
        int n2=Integer.MAX_VALUE;
        for(int num: nums){
            if(num<=n1)
                n1=num;
            else if(num<=n2)
                n2=num;
            else
                return true;
        }
        
        return false;
    }
}