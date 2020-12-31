package top_questions.medium.maths;

//https://leetcode.com/problems/sqrtx/
class SquareRoot {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        
        long l=2, r=x/2;
        while(l<=r){
            long mid = l + ((r-l)/2);
            long num = mid*mid;
            if(num>x)
                r=mid-1;
            else if (num<x)
                l=mid+1;
            else
                return (int)mid;
            
            
        }
        
        return (int)r;
        
    }
}