package top_questions.medium.string_and_array;
//https://leetcode.com/problems/set-matrix-zeroes/
class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isColumn=false, isRow=false;
        if(matrix[0][0]==0){
            isColumn= true;
            isRow=true;
        }
            
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0 && j!=0)
                        isRow=true;
                    if(j==0 && i!=0)
                        isColumn=true;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                     matrix[i][j]=0;
            }
        }
        
        if(isColumn){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
        
        if(isRow){
            for(int i=0;i<n;i++)
                matrix[0][i]=0;
        }
        
    }
}