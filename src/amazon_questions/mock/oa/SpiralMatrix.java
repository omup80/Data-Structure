package amazon_questions.mock.oa;

class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int i=1;
        int r=0;
        int c=0;
        while(i<=n*n){
            while(c<n&&matrix[r][c]==0){
                matrix[r][c]=i;
                c++;
                i++;
            }
            c--;
            r++;
            while(r<n&&matrix[r][c]==0){
                matrix[r][c]=i;
                r++;
                i++;
            }
            r--;
            c--;
            while(c>=0&& matrix[r][c]==0){
                matrix[r][c]=i;
                c--;
                i++;
            }
            c++;
            r--;
            
            while(r>=0&& matrix[r][c]==0){
                matrix[r][c]=i;
                r--;
                i++;
            }
          r++;
          c++;
        }
        
        return matrix;
    }
}