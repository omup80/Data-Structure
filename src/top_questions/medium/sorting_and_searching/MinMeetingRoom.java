package top_questions.medium.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinMeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new ArrayComparator1());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int[] interval: intervals){
            if(q.isEmpty() || q.peek()>interval[0]){
                q.add(interval[1]);
            }else{
                 q.remove();
                 q.add(interval[1]);
            }
                
            
                
        }
        
        return q.size();
    }
}

class ArrayComparator1 implements Comparator<int[]> {
    
    public int compare(int[] a, int[] b){
        if(a[0]!=b[0])
           return a[0]-b[0];
        return a[1]-b[1];
    }
}