package cracking_the_coding_interview.linked_list;

/**
 Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 Return the intersecting
 node. Note that the intersection is defined based on reference, not value.
 That is, if the kth
 node of the first linked list is the exact same node (by reference) as the jth node of the second
 linked list, then they are intersecting
 */
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        
        ListNode pa = headA, pb=headB;
        
        while( pa!= pb){
            pa = (pa != null) ? pa.next: headB;
            pb = (pb != null) ? pb.next: headA;
            
        }
        
        return pa;
        
        
    }
}