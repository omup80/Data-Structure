package top_questions.hard.linked_list;

import amazon_questions.linked_list.ListNode;

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
//https://leetcode.com/problems/sort-list/
class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode middle = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast = head;
        ListNode previous = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next!=null?fast.next.next:null;
            previous=slow;
            slow = slow.next;
        }
        previous.next=null;
        return slow;
        
    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                ptr.next = head1;
                head1 = head1.next;
            }else{
                ptr.next=head2;
                head2=head2.next;
            }
                
           ptr = ptr.next; 
                
        }
        
        if(head1!=null)
            ptr.next=head1;
        
        if(head2!=null)
            ptr.next=head2;
        
        return dummy.next;
        
    }
}