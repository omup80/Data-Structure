package amazon_questions.mock.telephonic_interview;

import java.util.*;

class HighFive {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        
        for(int[] item:items){
            List<Integer> marks = map.getOrDefault(item[0], new ArrayList<Integer>());
            marks.add(item[1]);
            map.put(item[0], marks);
        }
        
        int[][] result = new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            
            result[i][0] = e.getKey();
            List<Integer> marks = e.getValue();
            Collections.sort(marks);
            int sum=0;
            for(int j=marks.size()-1;j>=marks.size()-5;j--){
                sum=sum+marks.get(j);
            }
            result[i][1] = sum/5;
            i++;
        }
        
        return result;
    }
}