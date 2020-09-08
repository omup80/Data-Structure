package microsoft.sorting_and_searching;
//74. Search a 2D Matrix
//https://leetcode.com/problems/search-a-2d-matrix/
class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int nr = matrix.length;
        int nc = matrix[0].length;
        int n = nr * nc;
        int left = 0;
        int right = n-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            int r = getRow(mid, nc);
            int c = getColumn(mid, nc);
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
                
        }
        return false;
        
    }
    private int getRow(int n, int nc){
        return n/nc;
        
    }
    private int getColumn(int n, int nc){
        return n%nc;
    }
}