package top_questions.medium.back_tracking;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/generate-parentheses/
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        generateParenthesis(0, 0, n,"", result);
        
        return result;
        
    }
    
    private void generateParenthesis(int open, int close, int n, String parenthesis, List<String> result){
        
        if(close-open>0)
            return;
        
        if(close==n && open==n)
            result.add(parenthesis);
        
        if(open<n)
            generateParenthesis(open+1, close, n, parenthesis+"(", result);
        
        if(close<n)
            generateParenthesis(open, close+1, n, parenthesis+")", result);
        
        
    }
}