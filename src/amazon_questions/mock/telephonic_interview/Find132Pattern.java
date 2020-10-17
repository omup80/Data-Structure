package amazon_questions.mock.telephonic_interview;


import java.util.Stack;

class Find132Pattern {
    public boolean find132pattern(int[] nums) {
       Stack<Pair> stack = new Stack<Pair>();
        
          for(int num: nums){
                if(stack.empty() || num<= stack.peek().min){
                    stack.push(new Pair(num, num));
                }else{
                    if(num>stack.peek().min && num<stack.peek().max)
                        return true;
                    Pair last = stack.pop();
                    last.max=num;
                      
                    while(!stack.isEmpty()){
                        if(last.max>stack.peek().min && last.max<stack.peek().max)
                            return true;
                        if(last.min<stack.peek().min && last.max>stack.peek().max)
                            stack.pop();
                        else
                            break;
                        
                        
                        
                    }
                    stack.push(last);
                    
                    
                }

          }
        
        return false;
        
    }
    
    class Pair{
    int min;
    int max;
    public Pair(int min, int max){
        this.min = min;
        this.max = max;
    }
}
    
}
