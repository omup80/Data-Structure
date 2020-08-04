package amazon_questions.trees_and_graph;

import java.util.*;
/*
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents
the tree's height.
In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point
which is a tree you can decide whether or not to cut off the tree.

You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height
 first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees.
 If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:

Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6


Example 2:

Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1


Example 3:

Input:
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.


 */
class CutOfTrees {
    
    List<List<Integer>> forest;
    int [] dr = new int[]{-1,1,0,0};
    int [] dc = new int[]{0,0,-1,1};
    int R;
    int C;
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<int[]>();
        this.forest = forest;
        this.R = forest.size();
        this.C = forest.get(0).size();
        
        for(int i=0;i< R; i++){
            
            for(int j=0;j<C; j++){
                int v = getHeight(i, j);
                
                if(v>1) trees.add(new int[]{ v, i, j });     
            }
            
        }
        
        Collections.sort( trees, (a, b) -> Integer.compare(a[0], b[0]) );
        
        int sr = 0, sc=0;
        int dist = 0;
        for(int[] tree: trees){
           int steps =  bfs(sr, sc, tree[1], tree[2]);    
           if(steps==-1)
               return -1;
           dist = dist + steps; 
           sr = tree[1];
           sc = tree[2]; 
            
        }    
        
        return dist;
        
    }
    
    
    private int bfs(int sr, int sc, int tr, int tc){
        //Set<String> visited = new HashSet<String>();
        Queue<int[]> queue = new LinkedList<int []>();
        
        queue.add(new int[]{sr, sc, 0});
        
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        //visited.add(sr+"#"+sc);
        
        while(!queue.isEmpty()){
            int[] tree = queue.remove();
            
            if( tree[0]==tr && tree[1]==tc ) return tree[2];
            
            
            for(int di=0;di< 4;di++){
                int r = tree[0]+dr[di];
                int c = tree[1]+dc[di];
                
                //if(r>=0 && c>=0 && r<R && c < C && !visited.contains(r+"#"+c) && getHeight(r,c)>0){
                if(r>=0 && c>=0 && r<R && c < C && !seen[r][c] && getHeight(r,c)>0){

                    queue.add(new int[]{r, c, tree[2]+1});
                    //visited.add(r+"#"+c);
                    seen[r][c] = true;
               }
            }
            
                
            
            
        }
        
        return -1;
        
    }
    
    private int getHeight(int r, int c){
        List<Integer> row = forest.get(r);
        int treeHeight = row.get(c);
        return treeHeight;
        
    }
    
}