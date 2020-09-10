package microsoft.others;
//https://leetcode.com/problems/find-the-celebrity/
//277. Find the Celebrity
class Relation{
    int [][] relation;
    void Relation(int[][] relation){
        this.relation=relation;
    }
    public boolean knows(int i, int j){
        if(relation[i][j]==1)
            return true;
        return false;
    }
}
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
class Celebrity extends Relation {
    public int findCelebrity(int n) {
        int candidate=0;
        
        for(int i=0;i<n;i++){
            if(knows(candidate, i))
                candidate = i;
        }
        
        
        
        for(int i=0;i<n;i++){
            if(i!=candidate && (knows(candidate,i) || !knows(i, candidate)))
                return -1;
            
        }
        
        return candidate;
        
        
    }
}