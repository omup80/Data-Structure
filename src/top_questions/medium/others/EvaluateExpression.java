package top_questions.medium.others;

import java.util.Stack;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/
class EvaluateExpression {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1+n2);
            }else if("-".equals(tokens[i])){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2-n1);
            }else if("/".equals(tokens[i])){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2/n1);
            }else if("*".equals(tokens[i])){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2*n1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
                
            
            
        }
        
        return stack.pop();
    }
}