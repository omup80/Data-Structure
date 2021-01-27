package mock_test.facebook.oa;

import java.util.List;

//https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
// This is the BinaryMatrix's API interface.
  // You should not implement it, or speculate about its implementation
  interface BinaryMatrix {
    public int get(int row, int col);
    public List<Integer> dimensions();
  }


class LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
         List<Integer> dimensions = binaryMatrix.dimensions();
         int row = dimensions.get(0);
         int col = dimensions.get(1);
         int l=0;
         int r=col-1;
         while(l<=r){
             int mid = (l+r)/2;
             int count = countOne(row, mid, binaryMatrix);
             if(l==r && count>0)
                 return l;
             else if(count>0)
                 r=mid;
             else
                 l=mid+1;
             
         }
        return -1;
    }
    
    public int countOne(int totalRow, int currCol, BinaryMatrix binaryMatrix){
        int i=0;
        int count=0;
        while(i<totalRow){
            if(binaryMatrix.get(i, currCol)==1)
                count++;
            i++;    
        }
        
        return count;
    }
}