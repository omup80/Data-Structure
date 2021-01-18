package mock_test.generic.oa;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/find-anagram-mappings/
class AnagraMapping {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<B.length;i++){
            map.put(B[i], i);
        }
        int[] result = new int[A.length];
        for(int i=0;i<A.length;i++)
            result[i] = map.get(A[i]);
        return result;
    }
}