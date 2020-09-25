package google.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;

//753. Cracking the Safe
//https://leetcode.com/problems/cracking-the-safe/
class CrackingTheSafe {
    Set<String> visited = new HashSet<String>();
    StringBuilder pwd;
    public String crackSafe(int n, int k) {
        pwd = new StringBuilder();
        for(int i=0;i<n;i++){
            pwd.append('0');
        }
       
        visited.add(pwd.toString());
        int len = (int)Math.pow(k, n);
        backtracking(n, k, len);
        
        return pwd.toString();
    }
        
    private boolean backtracking(int n, int k, int len){
        
        if(visited.size()==len)
            return true;
        
        for(char x='0';x<'0'+k;x++){
            String sequence = pwd.substring(pwd.length()-n+1)+x;
            if(!visited.contains(sequence)){
               visited.add(sequence);
               pwd.append(x);
               if(backtracking(n,k,len))
                   return true;
                visited.remove(sequence);
                pwd.deleteCharAt(pwd.length()-1);
            }
            
        }
        
        return false;
    }
}