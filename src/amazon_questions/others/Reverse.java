package amazon_questions.others;
//7. Reverse Integer
//https://leetcode.com/problems/reverse-integer/
class Reverse {
    public int reverse(int x) {
        int r=0;
        while(x!=0){
            int pop=x%10;
            x = x/10;
            if(r > Integer.MAX_VALUE/10 || (r==Integer.MAX_VALUE/10 && pop>7)){
                return 0;
            }
            if(r < Integer.MIN_VALUE/10 || (r==Integer.MIN_VALUE/10 && pop<-8))
                return 0;
            
            r = r*10+pop;
        }
        return r;
    
    
    }
}