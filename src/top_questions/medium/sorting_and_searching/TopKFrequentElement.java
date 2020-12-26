package top_questions.medium.sorting_and_searching;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new FrequencyComparator());
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        for(int num: nums){
            Pair p = map.getOrDefault(num, new Pair(num, 0));
            p.freq++;
            map.put(num, p);
        }
        
        q.addAll(map.values());
        int[] result = new int[k];
        
        for(int i=0;i< result.length;i++)
            result[i]=q.remove().key;
        
        return result;
    }
}

class Pair{
    int key;
    int freq;
    public Pair(int key, int freq){
        this.key = key;
        this.freq = freq;
    }
}

class FrequencyComparator implements Comparator<Pair> {
    
    public int compare(Pair p1, Pair p2){
        return p2.freq-p1.freq;
        
    }
    
}