package google.others;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/minimum-area-rectangle/submissions/
//939. Minimum Area Rectangle
class MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet<Integer>();
        for(int[] point: points){
            pointSet.add(40001*point[0]+point[1]);
        }
        int minArea=Integer.MAX_VALUE;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]!=points[j][0] && points[i][1]!=points[j][1]){
                    if(pointSet.contains(40001*points[i][0]+points[j][1]) && pointSet.contains(40001*points[j][0]+points[i][1])){
                        int area = (points[i][0]-points[j][0])*(points[i][1]-points[j][1]);
                        minArea = Math.min(Math.abs(area), minArea);
                    
                }
            }
        }
        }
         return minArea < Integer.MAX_VALUE ? minArea : 0;
    }
}