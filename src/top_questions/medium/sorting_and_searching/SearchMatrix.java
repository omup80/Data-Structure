package top_questions.medium.sorting_and_searching;
//https://leetcode.com/problems/search-a-2d-matrix/
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length * matrix[0].length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid = (r+l)/2;
            int v = value(mid, matrix);
            if(v==target)
                return true;
            else if(v>target){
                r=mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
    
    private int value(int index, int[][] matrix){
        int i = matrix.length;
        int j = matrix[0].length;
        
        int r = index/j;
        int c = index%j;
        return matrix[r][c];
    }
}