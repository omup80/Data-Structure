package microsoft.backtracking;
//10. Regular Expression Matching
//https://leetcode.com/problems/regular-expression-matching/
class RegularExpression {
    Boolean[][] dp ;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        
        
        return match(s, p, 0, 0);
    }
    
    private boolean match(String s, String p, int i, int j){
        if(dp[i][j]!=null)
            return dp[i][j];
        boolean result ;
        if(j==p.length()){
            result= i==s.length();
        }else{
            
            boolean firstMatch = i<s.length()&&(s.charAt(i)== p.charAt(j) || p.charAt(j)=='.');
            
            if(j+1 < p.length() && p.charAt(j+1)=='*'){
                result =  match(s,p,i,j+2) ||(firstMatch&& match(s,p,i+1,j));
            }else{
                result = firstMatch && match(s,p,i+1,j+1); 
            }
            
            
        }
        dp[i][j] = result;
        return result;
    }
}