package top_questions.medium.maths;
//https://leetcode.com/problems/powx-n/
class Power {
    public double myPow(double x, int n) {
       long N = n;
        if(N<0){
           x = 1/x;
           N = -N;
       }
        return fastMul(x, N);
        
    }
    
    public double fastMul(double x, long n){
        if(n==0)
            return 1;
        double result = fastMul(x, n/2);
        if(n%2==0){
            
            return result*result;
        }

         return result*result*x;   
        
    }
}