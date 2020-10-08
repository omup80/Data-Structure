package amazon_questions.mock.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
       char[] c = S.toCharArray();
       Map<Character, Integer> map = new HashMap();
       for(int i=0;i<c.length;i++){
           map.put(c[i], i);
       }
       
       
        int j=0;
        List<Integer> result = new ArrayList();
       while(j<c.length){
           int max = map.get(c[j]);
           int k=1;
           while(j< c.length && j<max){
               
               max = Math.max(map.get(c[j]), max);
               j++;
               k++;
           }
           j++;
           result.add(k);
           
       } 
      
        return result;
    }
}