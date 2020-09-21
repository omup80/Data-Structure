package google.arrays_and_string;
//https://leetcode.com/problems/maximize-distance-to-closest-person/solution/
//849. Maximize Distance to Closest Person
class MaxDistanceToClosest {
    public int maxDistToClosest(int[] seats) {
        
        //for finding first
        int max=0;
        int startIndex=0;
        int i;
        for(i=0;i<seats.length;i++){
            if(seats[i]==1){
                max=i;
                startIndex=i;
                break;
            }
        }
        if(i==seats.length)
            return seats.length;
       int endIndex=seats.length-1; 
       for(i=endIndex;i>=0;i--){
           if(seats[i]==1){
               endIndex=i;
               break;
           }
       }     
       max = Math.max(max, seats.length-endIndex-1); 
        
       for(i=startIndex+1;i<=endIndex;i++){
           if(seats[i]==1){
               max = Math.max((i-startIndex)/2, max);
               startIndex=i;
           }
       } 
        return max;
    }
}