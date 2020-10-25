package amazon_questions.mock.onsite;

import java.util.*;

class ShortestPathWithAlternateColor {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
      
        int[][] graph = createGraph(red_edges, blue_edges, n);
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0,1});
        q.add(new int[]{0,-1});
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Set<String> visited = new HashSet();
        result[0]=0;
        int level=0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] a = q.remove();
                int node = a[0];
                int color = a[1];
                int oppositeColor = -1*a[1];
                for(int j=0;j<n;j++){
                    if(graph[node][j]==oppositeColor || graph[node][j]==0){
                        if(!visited.contains(j+"#"+oppositeColor)){
                            q.add(new int[]{j, oppositeColor});
                            result[j] = result[j]!=-1?Math.min(result[j], level): level;
                            visited.add(j+"#"+oppositeColor);
                        }
                    }
                }
                
            }
            
            
        }
        
                    return result;

    }
    
    private int[][] createGraph(int[][] red_edges, int[][] blue_edges, int n){
        int[][] graph = new int[n][n];
        for(int[] g: graph){
            Arrays.fill(g, -n);
        }
        
        for(int[] relation: red_edges){
            int from = relation[0];
            int to = relation[1];
            graph[from][to]=1;
            
        }
        
        for(int[] relation: blue_edges){
            int from = relation[0];
            int to = relation[1];
            
            if(graph[from][to]==1)
                graph[from][to]=0;
            else
                graph[from][to]=-1;
            
        }
        
        
        return graph;
    }
    
}