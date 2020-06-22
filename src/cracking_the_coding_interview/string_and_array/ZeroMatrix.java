package cracking_the_coding_interview.string_and_array;

import java.util.HashSet;
import java.util.Set;
/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 */
class ZeroMatrix {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setZeroesWithoutHashSet(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstColumn = false;
        boolean isFirstRow = false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;

                    if(i==0){
                        isFirstColumn=true;
                    }
                    if(j==0){
                        isFirstRow = true;
                    }
                }

            }

        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }

        if(isFirstRow){
            for(int i=1;i<m;i++){
                matrix[i][0]=0;
            }
        }

        if(isFirstColumn){
            for(int j=1;j<n;j++){
                matrix[0][j]=0;
            }
        }


    }
}