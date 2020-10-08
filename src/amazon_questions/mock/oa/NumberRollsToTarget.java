package amazon_questions.mock.oa;

import java.util.HashMap;
import java.util.Map;

class NumberRollsToTarget {
    int MODULO = (int)Math.pow(10, 9)+7;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int numRollsToTarget(int d, int f, int target) {
        return calculate(d, f, target);
    }
    
    private int calculate(int d,int f, int target){
        
        if(d==0 && target==0)
            return 1;
        if(d==0 && target!=0)
            return 0;
        
        int key = d*1000+target;
        if(map.containsKey(key))
            return map.get(key);
        int sum=0;
        for(int i=1;i<=f;i++){
            sum = (sum+calculate(d-1, f, target-i))%MODULO;   
        }
        map.put(key, sum);    
        return sum;
    }
}