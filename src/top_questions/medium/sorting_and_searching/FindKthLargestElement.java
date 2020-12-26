package top_questions.medium.sorting_and_searching;

import java.util.PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
class FindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int num: nums){
            q.add(num);
            if(q.size()>k)
                q.remove();
        }
        return q.remove();
    }
}
