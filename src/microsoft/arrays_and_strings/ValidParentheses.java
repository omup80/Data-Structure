package microsoft.arrays_and_strings;

import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/submissions/
//20. Valid Parentheses
class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
          char c = s.charAt(i);
            if(c=='{'|| c=='['|| c=='('){
                stack.push(c);
            }else if(c=='}' && !stack.isEmpty()){
                if(stack.pop()!='{')
                    return false;
            }else if(c==']' && !stack.isEmpty()){
                if(stack.pop()!='[')
                    return false;
            }else if(c==')' && !stack.isEmpty()){
                if(stack.pop()!='(')
                    return false;
            }else{
                return false;
            }
                
        }
        
        if(!stack.isEmpty())
            return false;
        return true;
    }
}