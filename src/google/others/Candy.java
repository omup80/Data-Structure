package google.others;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
//135. Candy
class Candy {
    public int candy(int[] ratings) {
        int[] lr = new int[ratings.length];
        int[] rl = new int[ratings.length];
        Arrays.fill(lr,1);
        Arrays.fill(rl,1);
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                lr[i] = lr[i-1]+1;
            }
            
        }
        
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rl[i] = rl[i+1]+1;
            }
            
        }
        
        int totalCandy=0;
        
        for(int i=0;i<ratings.length;i++){
            totalCandy += Math.max(lr[i],rl[i]);
        }
        
        return totalCandy;
        
    }
}