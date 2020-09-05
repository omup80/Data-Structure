package microsoft.linked_list;
//160. Intersection of Two Linked Lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA!=ptrB){
            ptrA = ptrA!=null?ptrA.next:headA;
            ptrB = ptrB!=null?ptrB.next:headB;
        }
        return ptrA;
    }
}