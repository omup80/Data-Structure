package amazon_questions.mock.oa;

import java.util.Comparator;
import java.util.PriorityQueue;

class KClosestPoint {
    public int[][] kClosest(int[][] points, int K) {
       Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int dis1  = a[0]*a[0]+a[1]*a[1];
                int dis2 =  b[0]*b[0]+b[1]*b[1];
                if(dis1>dis2)
                    return 1;
                else if(dis1<dis2)
                    return -1;
                  return 0;  
            }
        };
        
        PriorityQueue<int[]> q = new PriorityQueue(comparator);
        
        for(int[] point:points){
            q.add(point);
        }
        int[][] result = new int[K][2];
        while(!q.isEmpty() && K>0){
            result[K-1] = q.poll();
            K--;
        }
        return result;
    }
}