package amazon_questions.recursion;

import java.util.ArrayList;
import java.util.List;

class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        
        backtracking(combinations, "", 0, 0, n);
        return combinations;
        
    }
    
    private void backtracking(List<String> combinations, String combination, int open, int close, int n){
        if(combination.length() == 2*n){
              combinations.add(combination);
             return;

        }
        
        if(open < n)
            backtracking(combinations, combination +"(", open+1, close, n);

        if(close < open)
            backtracking(combinations, combination+")", open, close+1, n);
        
        
    }
}