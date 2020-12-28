package top_questions.medium.design;
//flattern the vector
//https://leetcode.com/problems/flatten-2d-vector/
class Vector2D {
    int[][] v;
    int r=0;
    int c=0;
    public Vector2D(int[][] v) {
        this.v = v;
    }
    
    public int next() {
        advanceToNext();
        return v[r][c++];
    }
    
    private void advanceToNext(){
       while(r<v.length && c==v[r].length){
           c=0;
           r++;
       } 
    }
    public boolean hasNext() {
           advanceToNext();
        if(r==v.length)
            return false;
        return true;
    }
    
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */