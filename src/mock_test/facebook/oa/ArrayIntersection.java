package mock_test.facebook.oa;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/intersection-of-three-sorted-arrays/
class ArrayIntersection {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        if(arr1.length>arr2.length)
           return  arraysIntersection(arr2, arr1, arr3);
        
        if(arr1.length>arr3.length)
           return  arraysIntersection(arr3, arr2, arr1);
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<arr1.length;i++){
            if(search(arr1[i], arr2) && search(arr1[i], arr3))
                result.add(arr1[i]);
        }
        return result;
    }
    
    public boolean search(int num, int[] arr){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]==num)
                return true;
            else if(arr[mid]>num)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}