package amazon_questions.mock.telephonic_interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/the-maze-ii/

class ShortestDistance {
    
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
      int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
      int[][] dist = new int[maze.length][maze[0].length];
      for(int[] row:dist){
          Arrays.fill(row, Integer.MAX_VALUE);
      }  
      
      Queue<int[]> q = new LinkedList();
      q.add(new int[]{start[0], start[1]});
      dist[start[0]][start[1]]=0;
        
      while(!q.isEmpty()){
        int[] s = q.remove();
        
        for(int[] d:dir){
            int x = s[0]+d[0];
            int y = s[1]+d[1];
            int count=0;
            while(x>=0 && x<maze.length && y>=0&&y<maze[0].length && maze[x][y]==0){
                count++;
                x +=d[0];
                y +=d[1];
            }
            
            if(dist[s[0]][s[1]]+count<dist[x-d[0]][y-d[1]]){
                dist[x-d[0]][y-d[1]] = dist[s[0]][s[1]]+count;
                q.add(new int[] {x-d[0], y-d[1]});
            }
        }  
       
          
      }
        
        
     
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:   dist[destination[0]][destination[1]];    
        
    }
}