package top_questions.medium.others;

import java.util.Arrays;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task: tasks)
            freq[task-'A']++;
        Arrays.sort(freq);
        int max = freq[25];
        int idle = (max-1) * n;
        
        for(int i=24;i>=0 && freq[i]>0;i--){
            idle -= Math.min(max-1, freq[i]);
            
        }
        
        idle = Math.max(0, idle);
        return tasks.length+idle;
        
    }
}