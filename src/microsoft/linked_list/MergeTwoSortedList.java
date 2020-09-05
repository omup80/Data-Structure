package microsoft.linked_list;

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
//https://leetcode.com/problems/merge-two-sorted-lists/
//21. Merge Two Sorted Lists
class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(l1!=null || l2!=null){
            
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    ptr.next=l1;
                    l1=l1.next;
                    ptr=ptr.next;
                    
                }else{
                    ptr.next=l2;
                    l2=l2.next;
                    ptr=ptr.next;
                }
            }else if(l1!=null){
                ptr.next = l1;
                break;
            }else{
                ptr.next = l2;
                break;
            }
            
            
            
        }
        return dummy.next;
    }
}