package top_questions.medium.maths;
//https://leetcode.com/problems/factorial-trailing-zeroes/
class TrailingZeroes {
    public int trailingZeroes(int n) {
        if(n<5)
            return 0;
        if(n>=5 && n<=9)
            return 1;
        
       int num=5; 
       int count=0;
       while(num<=n){
           count += findCount(num, n-(n%num), num);
           num = num * 5;
       }
       
        
       return count;
    }
    
    private int findCount(int a, int an, int d){
        return ((an-a)/d) + 1;
    }
        
}