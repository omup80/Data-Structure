package google.oa;

import java.util.TreeMap;
//https://leetcode.com/problems/odd-even-jump/submissions/
//975. Odd Even Jump
class OddEvenJumps {
    public int oddEvenJumps(int[] A) {
       int n = A.length;
       if(n<=1)
           return n;
       boolean[] odd = new boolean[n];
       boolean[] even = new boolean[n];
       odd[n-1]=true;    
       even[n-1]=true; 
       TreeMap<Integer, Integer> vals = new TreeMap<Integer, Integer>();
       vals.put(A[n-1], n-1);
        
       for(int i=n-2;i>=0;i--){
           
           int v = A[i];
           if(vals.containsKey(v)){
               odd[i] = even[vals.get(v)];
               even[i] = odd[vals.get(v)];
           }else{
              Integer lower = vals.lowerKey(v);
              Integer higher = vals.higherKey(v);
              if(lower!=null){
                  even[i] = odd[vals.get(lower)];
              } 
               
              if(higher!=null) {
                  odd[i] = even[vals.get(higher)];
              }
              
               
           }
           vals.put(v,i);
       }
        //Because you only count the positions where you first started, the first step has to be high/odd
        int result=0;
        for(int i=0;i<n;i++){
            if(odd[i])
                result++;
        }
      return result;
    }
}