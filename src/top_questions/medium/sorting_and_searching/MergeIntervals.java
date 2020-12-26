package top_questions.medium.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, new ArrayComparator());
        
        Stack<int[]> stack = new Stack<int[]>();
        
        for(int[] interval: intervals){
            if(stack.isEmpty() || stack.peek()[1]<interval[0]){
                stack.push(interval);
            }else{
                int[] i = stack.pop();
                if(interval[0]>=i[0] && interval[1]<=i[1]){
                    //do nothing
                    stack.push(i);
                }else {
                    i[1] = interval[1];
                    stack.push(i);
                }
            }
        }
        
        int[][] result = new int[stack.size()][2];
        for(int i=0;i<result.length;i++){
            result[i] = stack.pop();
        }
        return result;
    }
}

class ArrayComparator implements Comparator<int[]> {
    
    public int compare(int[] a, int[] b){
        if(a[0]!=b[0])
           return a[0]-b[0];
        return a[1]-b[1];
    }
}