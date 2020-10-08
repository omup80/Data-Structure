package amazon_questions.mock.oa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//https://leetcode.com/problems/minimum-knight-moves/
class MinimumKnightMoves {
    int[][] dir = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Set<String> visited = new HashSet();
        visited.add("0,0");
        Queue<int[]> q = new LinkedList();
        
        q.add(new int[]{0,0});
        int result=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                int[] pos = q.remove();
                
                if(pos[0]==x && pos[1]==y)
                    return result;
                
                for(int i=0;i<8;i++){
                    int newX = pos[0]+dir[i][0];
                    int newY = pos[1]+dir[i][1];
                    String cor = newX+","+newY ;
                   if(!visited.contains(cor) && newX>=-1 &&newY>=-1){
                       q.add(new int[]{newX, newY});
                       visited.add(cor);
                   } 
                    
                }
                
                
            }
            result++; 
        }
        
        return -1;
    }
    
    
}