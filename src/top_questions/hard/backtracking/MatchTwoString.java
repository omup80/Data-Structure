package top_questions.hard.backtracking;
//https://leetcode.com/problems/wildcard-matching/
class MatchTwoString {
    Boolean[][] dp ;
    String s, p;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        if(p.length()==0)
            return s.length()==0;
        this.s = s;
        this.p=removeDuplicate(p);
        return match(0,0);
    }
    
        

    public boolean match(int i,int j){
        if(dp[i][j]!=null)
            return dp[i][j];
        
        boolean result=false;
        if(j==p.length())
            result = i==s.length();
        else if(i==s.length() && ( j==p.length() || (j==p.length()-1 && p.charAt(j)=='*')))
            result = true;
        else if(i<s.length() && p.charAt(j)=='*')
            result=match(i, j+1) || match(i+1, j);
        else if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') )
            result = match(i+1, j+1);
        
            
        
       
        return dp[i][j]=result;
    }
public String removeDuplicate(String p){
        StringBuffer s = new StringBuffer();
        s.append(p.charAt(0));
        for(int i=1;i<p.length();i++){
            if(p.charAt(i)=='*'){
                if(p.charAt(i-1)!='*')
                    s.append(p.charAt(i));
            }else{
                s.append(p.charAt(i));
            }
                
        }
        return s.toString();
    }
}