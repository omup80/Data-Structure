package amazon_questions.others;

import java.util.HashMap;
import java.util.Map;
//957. Prison Cells After N Days
//https://leetcode.com/problems/prison-cells-after-n-days/
class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        boolean fastForward = false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(N>0){
            if(!fastForward){
                int bitmap = cellsToBitmap(cells);
                if(map.containsKey(bitmap)){
                    N = N%(map.get(bitmap)-N);
                }else{
                    map.put(bitmap, N);
                }
            }
            
            if(N>0){
                N = N-1;
                cells = nextDay(cells);
            }
            
        }
        return cells;
    }
    
    public int[] nextDay(int[] cells){
        int[] nextDay = new int[cells.length];
        nextDay[0]=0;
        nextDay[cells.length-1]=0;
        for(int i=1;i<cells.length-1;i++){
            nextDay[i] = (cells[i-1]==0 && cells[i+1]==0) || (cells[i-1]==1 && cells[i+1]==1)? 1:0;
        }
        
        return nextDay;
    }
    
    public int cellsToBitmap(int[] cells){
        int bitmap = 0x0;
        for(int cell:cells){
            bitmap <<=1;
            bitmap = bitmap | cell;
        }
        return bitmap;
    }
}