package microsoft.sorting_and_searching;
//https://leetcode.com/problems/merge-sorted-array/
//88. Merge Sorted Array
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int i = n;
        int j = 0;
        int index = 0;
        while (i < m + n || j < n) {

            if (i < m + n && j < n) {
                if (nums1[i] < nums2[j]) {
                    nums1[index] = nums1[i];
                    index++;
                    i++;
                } else {
                    nums1[index] = nums2[j];
                    index++;
                    j++;
                }

            } else if (j < n) {
                nums1[index] = nums2[j];
                index++;
                j++;

            } else {
                nums1[index] = nums1[i];
                index++;
                i++;
            }

        }
    }
}