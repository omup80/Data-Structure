package top_questions.hard.array_and_string;


//https://leetcode.com/problems/basic-calculator-ii/
class EvaluateExpression {
    public int calculate(String s) {
        
        int i=0,j=0;
        int currentNumber=0, lastNumber=0, result=0;
        char lo='+';
        while(j<s.length()){
            
            while(j<s.length() && !isOperator(s.charAt(j)))
                  j++;
            
             currentNumber = Integer.parseInt(s.substring(i,j).trim());
            
                if(lo=='+' || lo=='-'){
                    result += lastNumber;
                    lastNumber = lo=='-'?-currentNumber:currentNumber;
                    
                }else if(lo=='*'){
                    lastNumber = lastNumber * currentNumber;
                }else if(lo=='/'){
                   lastNumber = lastNumber / currentNumber;
                }
              
            if(j<s.length())  
                lo = s.charAt(j);
            
            
            j++;
            i=j;
        }
        result += lastNumber;
        return result;
    }
    
    private boolean isOperator(char op){
        
        if(op=='+' || op=='-' || op=='/' || op=='*')
            return true;
        return false;
            
    }
}