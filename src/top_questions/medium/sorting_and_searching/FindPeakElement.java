package top_questions.medium.sorting_and_searching;
//https://leetcode.com/problems/find-peak-element/
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    private int search(int[] nums, int l, int r){
        if(l==r)
            return l;
        int middle = (l+r)/2;
        if(nums[middle]>nums[middle+1])
            return search(nums,l, middle);
        return search(nums, middle+1, r);
    }
}