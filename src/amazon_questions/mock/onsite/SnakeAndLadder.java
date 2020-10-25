package amazon_questions.mock.onsite;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SnakeAndLadder {
    
    
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        
        Set<Integer> visited=new HashSet();
        visited.add(1);
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(1, 0));
        
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            if(p.pos==n*n)
                return p.moves;
            for(int i=1;i<=6;i++){
                int curPos = p.pos+i;
                if(!visited.contains(curPos) && curPos<=n*n){
                    visited.add(curPos);
                   int[] coor = getCordinated(curPos, n);
                   int x = coor[0];
                   int y = coor[1];
                    if(board[x][y]!=-1){
                        queue.add(new Pair(board[x][y], p.moves+1));
                    }else{
                        queue.add(new Pair(curPos, p.moves+1));
                    }
                }
            }
            
            
        }
        
        
        return -1;
    }
    
    
    private int[] getCordinated(int pos, int n){
        int row = n -1 -(pos-1)/n;
        int col;
        if(n%2==0)
            col = row%2==0?n-1-(pos-1)%n:(pos-1)%n;
        else
            col = row%2==1?n-1-(pos-1)%n:(pos-1)%n;
        return new int[]{row,col};
    }
    
   class Pair{
       int pos;
       int moves;
       public Pair(int pos,int moves){
           this.pos = pos;
           this.moves = moves;
       }
   } 
}