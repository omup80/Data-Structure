package top_questions.medium.maths;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/happy-number/
class isHappy {
    Set<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        
        if(set.contains(n))
            return false;
        set.add(n);
        int sum=0;
        while(n>0){
            int digit = n%10;
            n = n/10;
            sum += digit * digit;
        }
        
        if(sum==1)
            return true;
        
        return isHappy(sum);
    }
}