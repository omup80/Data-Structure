package mock_test.facebook.oa;
//https://leetcode.com/problems/merge-two-sorted-lists/
import amazon_questions.linked_list.ListNode;

class MergeLinkList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3Head = new ListNode();
        ListNode ptr = l3Head;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                ptr.next = l1;
                ptr=ptr.next;
                l1=l1.next;
            }else{
                ptr.next = l2;
                ptr=ptr.next;
                l2=l2.next;
                
            }
        }
        
        if(l1!=null)
            ptr.next = l1;
        if(l2!=null)
            ptr.next = l2;
        
        return l3Head.next;
    }
}