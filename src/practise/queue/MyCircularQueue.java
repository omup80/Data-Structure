package practise.queue;
/*
Design your implementation of the circular practise.queue. The circular practise.queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular practise.queue is that we can make use of the spaces in front of the practise.queue. In a normal practise.queue, once the practise.queue becomes full, we cannot insert the next element even if there is a space in front of the practise.queue. But using the circular practise.queue, we can use the space to store new values.

Your implementation should support following operations:

MyCircularQueue(k): Constructor, set the size of the practise.queue to be k.
Front: Get the front item from the practise.queue. If the practise.queue is empty, return -1.
Rear: Get the last item from the practise.queue. If the practise.queue is empty, return -1.
enQueue(value): Insert an element into the circular practise.queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular practise.queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular practise.queue is empty or not.
isFull(): Checks whether the circular practise.queue is full or not.
 */
public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the practise.queue to be k. */
    int[] queue;
    int startIdx;
    int endIdx;
    int size;
    int maxLength;
    public MyCircularQueue(int k) {
        queue = new int[k];
        startIdx = 0;
        endIdx = -1;
        size = 0;
        maxLength = k;

    }

    /** Insert an element into the circular practise.queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size==maxLength)
            return false;

        endIdx = (endIdx + 1)% maxLength;
        queue[endIdx] = value;
        size = size+1;
        return true;
    }

    /** Delete an element from the circular practise.queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size==0)
            return false;

        startIdx = (startIdx+1)%maxLength;
        size = size-1;
        return true;
    }

    /** Get the front item from the practise.queue. */
    public int Front() {
        if(size==0)
            return -1;
        return queue[startIdx];
    }

    /** Get the last item from the practise.queue. */
    public int Rear() {
        if(size==0)
            return -1;
        return queue[endIdx];
    }

    /** Checks whether the circular practise.queue is empty or not. */
    public boolean isEmpty() {
        if(size == 0 )
            return true;
        return false;
    }

    /** Checks whether the circular practise.queue is full or not. */
    public boolean isFull() {
        if(size==maxLength)
            return true;
        return false;
    }
}
