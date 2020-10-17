package amazon_questions.mock.telephonic_interview;

import java.util.Arrays;

class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i=0;
        int j=A.length-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            if(A[i]+A[j]>=K){
                j--;
            }else if(A[i]+A[j]<K){
                max= Math.max(max, A[i]+A[j]);
                i++;
            }
        }
        
        
        
        return max!=Integer.MIN_VALUE?max:-1;
    }
}