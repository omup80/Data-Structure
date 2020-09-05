package microsoft.arrays_and_strings;
//48. Rotate Image
//https://leetcode.com/problems/rotate-image/
class RotateImage {
    public void rotate(int[][] matrix) {
      int nr = matrix.length;
      int nc = matrix[0].length;  
      for(int i=0;i<nr;i++){
          for(int j=i;j<nc;j++){
              int temp = matrix[j][i];
              matrix[j][i] = matrix[i][j];
              matrix[i][j] = temp;
          }
      }

      for(int i=0;i<nr;i++){
          for(int j=0; j<= (nc-1)/2;j++){
              int temp = matrix[i][j];
              matrix[i][j]=matrix[i][nc-1-j];
              matrix[i][nc-1-j] = temp;
          }
          
      }  
        
        
        
        
    }
}