package top_questions.medium.linked_list;

import amazon_questions.linked_list.ListNode;
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class GetIntersectionOfNodes {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        if(l1==null || l2==null)
            return null;
        while(l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
            
            if(l1==l2)
                return l1;
            
            if(l1==null)
                l1=headB;
            
            if(l2==null)
                l2=headA;
            
        }
        return l1;
    }
}