package top_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/remove-invalid-parentheses/
class RemoveInvalidParenthesis {
    Set<String> result = new HashSet<String>();
    String s;
    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        int leftRem=0;
        int rightRem=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                leftRem++;
            }else if(s.charAt(i)==')'){
                rightRem = leftRem==0?rightRem+1:rightRem;
                leftRem=leftRem>0?leftRem-1:leftRem;
            }
        }
        process(0, 0, 0, leftRem, rightRem, new StringBuilder());
        return new ArrayList<String>(result);
        
    }
    
    public void process(int i, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder sb){
        
        
        if(i==s.length() ){
            if(leftRem==0 && rightRem==0)
                 result.add(sb.toString());
        }else{
            
            char c = s.charAt(i);
            int length = sb.length();
            //exclude
            if((c=='(' && leftRem>0)  || (c==')' && rightRem>0)){
                process(i+1, leftCount, rightCount, c=='('?leftRem-1:leftRem, c==')'?rightRem-1:rightRem, sb);
                
            }
            
            // include
            sb.append(c);
            if(c=='('){

                process(i+1, leftCount+1, rightCount, leftRem, rightRem, sb);
                
            }else if(c==')' && leftCount-rightCount>0){
                
                process(i+1, leftCount, rightCount+1, leftRem, rightRem, sb);
                
            }else if(c!='(' && c!=')'){

                process(i+1, leftCount, rightCount, leftRem, rightRem, sb);
                
            }
            
            sb.deleteCharAt(length);
            
        }
        
        
    }
}