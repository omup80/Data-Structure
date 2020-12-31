package top_questions.medium.maths;
//https://leetcode.com/problems/divide-two-integers/
class Divide {
    int MIN_HALF = Integer.MIN_VALUE/2;
    
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        
        int negative = 2;
        if(dividend>0){
            dividend = -dividend;
            negative--;
        }
        
        if(divisor>0){
            divisor = -divisor;
            negative--;
            
        }
        
        int quotient = 0;
        while(dividend<=divisor){
            int powerOfTwo = -1;
            int value = divisor;
            
            while(value>=MIN_HALF && value+value>=dividend){
                powerOfTwo += powerOfTwo;
                value += value;
            }
            dividend -= value;
            quotient += powerOfTwo;
        }
        
        if(negative==1)
            return quotient;
        return -quotient;
            
    }
}