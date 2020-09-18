package google.others;
//https://leetcode.com/problems/bulls-and-cows/submissions/
//299. Bulls and Cows

class CowsAndBulls {
    public String getHint(String secret, String guess) {
      int[] map = new int[10];
      int bulls=0, cow=0;
      for(int i=0;i<secret.length();i++){
          char s = secret.charAt(i);
          char g = guess.charAt(i);
          if(s==g){
              bulls++;
          }else{
              
              if(map[s-'0']<0)
                  cow++;
              if(map[g-'0']>0)
                  cow++;
              map[s-'0']++;
              map[g-'0']--;
          }
          
          
      }  
StringBuilder sb = new StringBuilder();
        sb.append(bulls); 
        sb.append("A"); 
        sb.append(cow); 
        sb.append("B");
        return sb.toString();
    }
}