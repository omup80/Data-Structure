package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
/*
Complexity

Time Complexity: O(1), as we can see that there is no loop in the next(val) function.
Space Complexity: O(N), where NN is the size of the circular queue.
 */
public class MovingAverage {
    /** Initialize your data structure here. */
    private int sumInWindow = 0;
    Queue<Integer> queue = new LinkedList<Integer>();
    private int size ;
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(size == queue.size()){
            int removedValue = queue.remove();
            sumInWindow = sumInWindow - removedValue;
        }
        queue.add(val);
        sumInWindow = sumInWindow + val;
        return (double)sumInWindow / queue.size();

    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
