package amazon_questions.linked_list;

/*
Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


 */
class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
       ListNode preHead = new ListNode(-1);
       ListNode prev = preHead; 
        while(l1!=null && l2!=null){
            
            
                if(l1.val<l2.val){
                    prev.next = l1;
                    
                    l1 = l1.next;
                }else{
                    prev.next = l2;
                    l2 = l2.next;
                }
                
              prev = prev.next;;
            
            
        }
        
        prev.next = l1==null? l2: l1;
        
        return preHead.next;
      
    
    }
}