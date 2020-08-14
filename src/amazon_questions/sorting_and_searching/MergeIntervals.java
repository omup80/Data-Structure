package amazon_questions.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (int[] s1, int[] s2) -> s1[0].compareTo(s2[0]));
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[0] > entry2[0]) 
                return 1; 
            else if(entry1[0]<entry2[0])
                return -1;
             else
                 return 0;
          } 
        });
        
        
        Stack<int[]> stack = new Stack<int[]>();
        for(int i=0;i<intervals.length;i++){
             if(stack.isEmpty()){
                 stack.push(intervals[i]);
             }else{
                int [] temp = stack.pop();
                if(intervals[i][0] <temp[1] && intervals[i][1]<temp[1]){
                    stack.push(temp);
                }else if(intervals[i][0] <= temp[1] && temp[1]<=intervals[i][1]){
                    stack.push(new int[]{temp[0], intervals[i][1]});
                //}//else if(intervals[i][0] >temp[1] && intervals[i][1]>temp[1]){
                   // stack.push(intervals[i]);
                //}else if(temp[0]<=intervals[i][1] && intervals[i][1]<=temp[1]){
                  //  stack.push(new int[]{intervals[i][0], temp[1]});
                }else{
                    stack.push(temp);
                    stack.push(intervals[i]);
                } 
             }   
        }
        
        int size = stack.size();
        int[][] result = new int[size][2];
        
        for(int i=size-1;i>=0;i--){
            result[i] = stack.pop();
        }
        
        return result;
        
    }
}