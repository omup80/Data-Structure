package microsoft.arrays_and_strings;
//73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/
class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
     
     int nr = matrix.length;
     int nc = matrix[0].length;   
     boolean isRow=false;
     boolean isCol=false;  
     for(int r=0;r<nr;r++){
         for(int c=0;c<nc;c++){
             if(matrix[r][c]==0){
                 matrix[r][0]=0;
                 matrix[0][c]=0;
                 if(r==0)
                     isRow=true;
                 if(c==0)
                     isCol=true;
             }
                 
         }
     }  
        
      for(int r=1;r<nr;r++){
          for(int c=1;c<nc;c++){
              if(matrix[r][0]==0 || matrix[0][c]==0){
                  matrix[r][c]=0;
              }
          }
      }
         
      if(isRow){
          for(int c=0;c<nc;c++){
              matrix[0][c]=0;
          }
      }
      
      if(isCol){
          for(int r=0;r<nr;r++){
              matrix[r][0]=0;
          }
      }   
         
        
        
       
  }
}