package amazon_questions.mock.oa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//https://leetcode.com/problems/rotting-oranges/

class RottonOranges {
    int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        int nr=grid.length;
        int nc = grid[0].length;
        int fresh = 0;
        Queue<int[]> q= new LinkedList();
        for(int r=0;r<nr;r++){
            for(int c=0;c<nc;c++){
                if(grid[r][c]==1)
                    fresh++;
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }    
            }
        }
        if(fresh==0)
            return 0;
        int min=0;
        Set<String> visited= new HashSet();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] pos = q.remove();
                for(int[] dir:direction){
                    int x = pos[0]+dir[0];
                    int y = pos[1] +dir[1];
                    if(x>=0 && y>=0 && x<nr && y<nc && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            min++;
            if(fresh==0)
                return min;
        }
        return -1;
    }
}