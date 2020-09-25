package google.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;
//947. Most Stones Removed with Same Row or Column
//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
class RemoveStones {
    
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);
        for(int[] stone: stones){
            dsu.union(stone[0], stone[1]+10000);
        }
        Set<Integer> visited = new HashSet<Integer>();
        for(int[] stone: stones){
            visited.add(dsu.find(stone[0]));
            
        }
        return stones.length - visited.size();
    }
    
    class DSU{
        int[] parent;
        
        public DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        
        public int find(int x){
            while(x!=parent[x])
               x = parent[x];
            return x;    
        }
        public void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }    
    
    
}