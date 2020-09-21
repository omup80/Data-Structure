package google.arrays_and_string;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for(int i=0;i<quality.length;i++){
            workers[i] = new Worker(quality[i],wage[i]);
        }
        Arrays.sort(workers);
        
        PriorityQueue<Integer> pool = new PriorityQueue();
        int sumq=0;
        double min=1e9;
        for(Worker worker: workers){
            pool.add(-worker.quality);
            sumq += worker.quality;
            
            if(pool.size()>K){
                sumq += pool.poll();
            }
            if(pool.size()==K){
                min = Math.min(min, sumq*worker.ratio());
            }
        }
        
        return min;
    }
}


class Worker implements Comparable<Worker>{
    public int quality, wage;
    
    public Worker(int quality, int wage){
        this.quality = quality;
        this.wage = wage;
    }
    public double ratio(){
        return (double) wage/quality;
    }
    public int compareTo(Worker other){
        return Double.compare(ratio(), other.ratio());
    }
}