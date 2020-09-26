package google.recursion;
//https://leetcode.com/problems/android-unlock-patterns/
//351. Android Unlock Patterns
class AndroidUnlockPattern {
    int[][] skip;
    public int numberOfPatterns(int m, int n) {
      skip = new int[10][10];
      skip[1][3]= skip[3][1] = 2;
      skip[1][7] = skip[7][1] = 4;
      skip[3][9] = skip[9][3] = 6    ;
      skip[7][9] = skip[9][7]=8   ; 
      skip[1][9]  = skip[9][1]=skip[2][8]=skip[8][2]=skip[3][7]=skip[7][3]=skip[4][6]=skip[6][4]=5;
      int result=0;
      boolean[] visited = new boolean[10]; 
      for(int i=m;i<=n;i++){
         visited[1]= true;
         result +=countPattern(visited,1, i-1)*4;
         visited[1]= false;
         visited[2]= true;
         result +=countPattern(visited,2, i-1)*4;
         visited[2]= false;
         visited[5] = true; 
         result +=countPattern(visited,5, i-1); 
         visited[5]= false; 
      }  
      return result;    
      
          
    }
    
    private int countPattern(boolean[] visited,int cur, int remaining){
        if(remaining==0)
            return 1;
        int result=0;
        for(int i=1;i<=9;i++){
            if(!visited[i] && (skip[cur][i]==0|| visited[skip[cur][i]])){
                visited[i]=true;
                result += countPattern(visited, i, remaining-1);
                visited[i]=false;
            }  

        }
           return result;                                              
    }
    
}