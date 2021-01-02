package top_questions.medium.others;
//https://leetcode.com/problems/sum-of-two-integers/
class Addition {
    public int getSum(int a, int b) {
        while(b!=0){
             int ans = a^b;
             int carry = (a & b)<<1;
            a = ans;
            b = carry;
        }
        
        return a;
    }
}