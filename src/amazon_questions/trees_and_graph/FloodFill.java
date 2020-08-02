package amazon_questions.trees_and_graph;
/*

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 */
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        
        int nr = image.length;
        int nc = image[0].length;
        int color = image[sr][sc];
        if(color!=newColor) dfs(image, sr, sc, nr, nc, newColor, color);
        return image;
        
    }
    private void dfs(int[][] image, int r, int c,int nr, int nc, int newColor, int color){
        
    
  if(r<0 || c<0 || r==nr || c==nc)
        return;
        
    
    if(image[r][c]==color){
      
         image[r][c] = newColor;
     
        dfs(image, r-1, c, nr, nc, newColor, color);
        dfs(image, r, c-1, nr, nc, newColor, color);
        dfs(image, r+1, c, nr, nc, newColor, color);
        dfs(image, r, c+1, nr, nc, newColor, color);
        
           
    }
         

    }
}