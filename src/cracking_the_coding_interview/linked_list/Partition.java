package cracking_the_coding_interview.linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions
 */
class Partition {
    public ListNode partition(ListNode head, int x) {
    
    if(head==null){
        return head;
    }    
    ListNode smaller = null;
    ListNode newHead =null;
    ListNode iHead = head; 
        
    while(iHead != null){
        
        if(iHead.val < x){
             if(smaller==null){
                 smaller = new ListNode(iHead.val);
                 newHead = smaller;
             }else{
                 smaller.next = new ListNode(iHead.val);
                 smaller = smaller.next;
             }
            
        }   
        iHead = iHead.next;
    
    }
        
    iHead = head;
        
    while(iHead!= null && iHead.val !=x){
        if(iHead.val > x){
           if(smaller==null){
               smaller = new ListNode(iHead.val);
               newHead = smaller;
           }else{
             smaller.next = new ListNode(iHead.val);
             smaller = smaller.next;
  
           } 
            
        }
        iHead=iHead.next;   
    
    }    
        
    while(iHead!= null){
      if(iHead.val >= x){
       if(smaller==null){
               smaller = new ListNode(iHead.val);
               newHead = smaller;
           }else{
             smaller.next = new ListNode(iHead.val);
             smaller = smaller.next;
  
           }
      }
      iHead = iHead.next;  
    
    }
    
    
    return newHead;    
    }
    public ListNode partitionBetterSolution(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }


}