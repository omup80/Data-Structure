package amazon_questions.mock.oa;

import java.util.Arrays;
//https://leetcode.com/problems/relative-sort-array/
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
class RelativeSortOfArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i, j,k;
        i=j=k=0;
        
       while(k<arr2.length){
           while(j<arr1.length){
               if(arr1[j]==arr2[k]){
                   int temp =arr1[j];
                   arr1[j]=arr1[i];
                   arr1[i] = temp;
                   i++;
               }
               j++;
           }
           k++;
           j=i;
       }
      if(i<arr1.length-1){
          Arrays.sort(arr1, i, arr1.length);
      }  
      return arr1;  
    }
}