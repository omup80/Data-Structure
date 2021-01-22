package mock_test.facebook.oa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//https://leetcode.com/problems/sort-the-matrix-diagonally/
class DiagonalSort {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                PriorityQueue<Integer> q = map.getOrDefault(i-j, new PriorityQueue<Integer>());
                q.add(mat[i][j]);
                map.put(i-j, q);
            }
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = map.get(i-j).remove();
            }
        }
        return mat;
    }
    
    
}