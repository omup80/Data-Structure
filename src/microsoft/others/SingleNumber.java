package microsoft.others;
//https://leetcode.com/problems/single-number/
//136. Single Number

class SingleNumber {
    public int singleNumber(int[] nums) {
        int a=0;
        for(int num:nums){
            a = a^num;
        }
        return a;
    }
}