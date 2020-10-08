package amazon_questions.mock.oa;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q = new LinkedList<Integer>();
    int size;
    double sum=0;
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size()!=size){
            q.add(val);
            sum=sum+val;
        }else{
            sum = sum - q.remove();
            q.add(val);
            sum=sum+val;
        }
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */