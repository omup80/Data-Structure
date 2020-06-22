package cracking_the_coding_interview.string_and_array;


/*


Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
class RotateMatrix {
    public void rotate(int[][] matrix) {
        
        int n = matrix[0].length;
        int N = n-1;
        
        for(int i=0; i<(n+1)/2;i++){
           
            for(int j=i;j<n-i-1;j++){
               int temp1=matrix[j][N-i];
               matrix[j][N-i] = matrix[i][j];
               //System.out.println(" m["+j+"]["+(N-i)+"]="+matrix[j][N-i]);
               int temp2 = matrix[N-i][N-j];
               matrix[N-i][N-j] = temp1;
              //System.out.println(" m["+(N-i)+"]["+(N-j)+"]="+matrix[N-i][N-j]);

               temp1 = matrix[N-j][i]; 
               matrix[N-j][i] = temp2;
               //System.out.println(" m["+(N-j)+"]["+i+"]="+matrix[N-j][i]);

               
               
               matrix[i][j] = temp1;
                
              //System.out.println(" m["+i+"]["+j+"]="+matrix[i][j]);
 
           
            } 
            
            
            
            
            
        }
        
        
    }


    public void rotate_simple(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}