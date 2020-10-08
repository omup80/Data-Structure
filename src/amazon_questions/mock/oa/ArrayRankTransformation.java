package amazon_questions.mock.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ArrayRankTransformation {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)
            return arr;
        
        int[] copied = arr.clone();
        Arrays.sort(copied);
        int rank=1;
        Map<Integer, Integer> map = new HashMap();
        map.put(copied[0],rank++);
        for(int i=1;i<copied.length;i++){
               if(copied[i]!=copied[i-1]){
                   map.put(copied[i],rank);
                   rank++;
               }
            
        }
        
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}