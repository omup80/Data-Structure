package practise.arrays;

import java.util.ArrayList;
import java.util.List;
/*
Given an initial array arr, every day you produce a new array using the array of the previous day.

On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:

If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
The first and last elements never change.
After some days, the array does not change. Return that final array.T

 */
public class ArrayTransformation {
    public List<Integer> transformArray(int[] arr) {

        boolean isUpdated = true;

        while(isUpdated){


            isUpdated = updateArray(arr);

        }

        List<Integer> changedArray = new ArrayList<>();

        for (Integer i : arr) {
            changedArray.add(Integer.valueOf(i));
        }
        return changedArray;

    }



    private boolean updateArray(int[] arr){
        boolean isUpdated = false;
        int previousValue = arr[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]<previousValue && arr[i]<arr[i+1]){
                previousValue = arr[i];
                arr[i] = arr[i] + 1;
                isUpdated = true;
            }else if(arr[i]>previousValue && arr[i]>arr[i+1]){
                previousValue = arr[i];
                arr[i] = arr[i] - 1;
                isUpdated = true;
            }else{
                previousValue = arr[i];
            }
        }

        return isUpdated;
    }
}
