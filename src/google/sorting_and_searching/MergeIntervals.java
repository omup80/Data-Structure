package google.sorting_and_searching;

import java.util.Stack;
//https://leetcode.com/problems/insert-interval/
//57. Insert Interval
class MergeIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      
      if(intervals==null || intervals.length==0){
          return new int[][]{newInterval};
      }  
        
      Stack<int[]> st = new Stack<int[]>();
      boolean isNewIntervalUsed = false;  
      for(int[] interval: intervals){
          if(!isNewIntervalUsed){
              
              if(intervalIntersection(interval, newInterval)){
                  st.push(getMergedInterval(interval, newInterval));
                  isNewIntervalUsed=true;
              }else if(newInterval[0] < interval[0] && newInterval[1]<interval[0]){
                  st.push(newInterval);
                  st.push(interval);
                  isNewIntervalUsed = true;
              }else{
                 st.push(interval);
              }
              
              
              
          }else{
              if(!st.isEmpty()){
                 if(intervalIntersection(st.peek(), interval))
                     st.push(getMergedInterval(st.pop(), interval));
                 else
                     st.push(interval);
                  
              }else{
                  st.push(interval);
              }
          }
              
      }
      if(!isNewIntervalUsed)
          st.push(newInterval);
      int[][] newIntervals = new int[st.size()][2];
      for(int i=st.size()-1;i>=0;i--){
          newIntervals[i] = st.pop();
      }
      
      return newIntervals;  
    }
    
    private int[] getMergedInterval(int[] interval,int[] newInterval){
              int[] temp = new int[2];
              temp[0]= Math.min(interval[0], newInterval[0]);
              temp[1] = Math.max(interval[1], newInterval[1]);
        return temp;
    }
    private boolean intervalIntersection(int[] i, int[] ni){
        if((ni[0]<i[0] && ni[1]<i[0]) || (i[0]<ni[0] && i[1]<ni[0]))
            return false;
        return true;
    }
}

