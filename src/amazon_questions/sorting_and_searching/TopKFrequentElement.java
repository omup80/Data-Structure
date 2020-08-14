package amazon_questions.sorting_and_searching;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
     
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
            
        }
        
  
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue(
            map.size(),
            new Comparator<Pair<Integer, Integer>>(){
                public int compare(final Pair<Integer, Integer> a, Pair<Integer, Integer> b){
                    return b.getValue() - a.getValue();
                }
            }  
        );
        
       for (Integer key : map.keySet()){
           pq.add(new Pair(key, map.get(key)));
       }  
       
       int[] result = new int[k];
        
       for(int i=0;i<k;i++){
           result[i] = pq.poll().getKey();
       }
        
      return result;  
        
    }
}