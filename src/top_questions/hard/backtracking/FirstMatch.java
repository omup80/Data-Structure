package top_questions.hard.backtracking;
//https://leetcode.com/problems/regular-expression-matching/
class FirstMatch {
    String s;
    String p;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        this.s=s;
        this.p=p;
        dp = new Boolean[s.length()+1][p.length()+1];
        return isMatch(0, 0);
    }
    
    public boolean isMatch(int i, int j){
        if(dp[i][j]!=null)
            return dp[i][j];
        
        boolean result;
        if(j==p.length()){
            result = i==s.length();
        }else{
             boolean isFirstMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j)=='.');
            
            if(j+1<p.length() && p.charAt(j+1)=='*')
                result = isMatch(i, j+2) || (isFirstMatch && isMatch(i+1, j));
            else
                result = isFirstMatch && isMatch(i+1, j+1);
        }
        
                
        
        return dp[i][j]=result;
            
        
    }
}