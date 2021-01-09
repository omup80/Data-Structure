package top_questions.hard.trees;

import java.util.*;
//https://leetcode.com/problems/number-of-provinces/
class ConnectedComponent {
    Map<Integer, List<Integer>> map = new HashMap();
    Set<Integer> visited = new HashSet<Integer>();
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                     List<Integer> ichildren = map.getOrDefault(i, new ArrayList<Integer>());
                     ichildren.add(j);
                     map.put(i, ichildren);
                    
                     List<Integer> jchildren = map.getOrDefault(j, new ArrayList<Integer>());
                     jchildren.add(i);
                     map.put(j, jchildren);
                }
                           
            }
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                component++;
                dfs(i, visited);
            }
            
            
        }
        return component;
        
    }
    
    public void dfs(int i, Set<Integer> visited){
        visited.add(i);
        
        for(Integer child: map.getOrDefault(i, new ArrayList<Integer>())){
            if(!visited.contains(child)){
                dfs(child, visited);
            }
        }
        
    }
}