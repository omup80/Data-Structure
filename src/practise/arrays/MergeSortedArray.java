package practise.arrays;

public class MergeSortedArray {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m-1, j=n-1, k=m+n-1;
            while(k>=0){
                if(j>=0 && i>=0  && nums1[i] >= nums2[j] ){
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                }else if(j>=0 && i>=0 && nums2[j] >= nums1[i]){
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }else if(i>=0){
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                }else{
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }


            }

        }

}
