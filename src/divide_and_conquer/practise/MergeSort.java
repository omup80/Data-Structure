package divide_and_conquer.practise;

import java.util.Arrays;

public class MergeSort {
    public int[] sortArray(int[] nums) {

        if(nums.length <=1)
            return nums;

        int pivot = nums.length/2;

        int[] leftPart = sortArray(Arrays.copyOfRange(nums,0, pivot));
        int[] rightPart = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(leftPart, rightPart);



    }

    int[] merge(int[] leftPart, int[] rightPart){
        int[] sortedArray = new int[leftPart.length + rightPart.length];
        int sortIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftPart.length && rightIndex < rightPart.length){
            if(leftPart[leftIndex] < rightPart[rightIndex]){
                sortedArray[sortIndex] = leftPart[leftIndex];
                sortIndex++;
                leftIndex++;
            }else{
                sortedArray[sortIndex] = rightPart[rightIndex];
                sortIndex++;
                rightIndex++;
            }


        }

        while(leftIndex < leftPart.length){

            sortedArray[sortIndex] = leftPart[leftIndex];
            sortIndex++;
            leftIndex++;

        }

        while(rightIndex< rightPart.length){

            sortedArray[sortIndex] = rightPart[rightIndex];
            sortIndex++;
            rightIndex++;

        }


        return sortedArray;


    }


}
