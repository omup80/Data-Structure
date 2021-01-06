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
//https://leetcode.com/problems/merge-k-sorted-lists/
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        int com=1;
        int jump=2;
        while(jump/2<lists.length){
            
            for(int i=0;i<lists.length;i=i+jump)
                lists[i] = i+com>=lists.length? lists[i]:merge(lists[i], lists[i+com]);
            com *=2;
            jump *=2;
            
        }
        
        return lists[0];
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode();
       ListNode ptr = dummy;
        
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                ptr.next = head1;
                head1=head1.next;
            }else{
                ptr.next=head2;
                head2=head2.next;
                
            }
            ptr=ptr.next;
        }
        
        if(head1!=null)
            ptr.next=head1;
        if(head2!=null)
            ptr.next=head2;
        return dummy.next;
    }
}