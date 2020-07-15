package amazon_questions.linked_list;

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
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
        ListNode ptr = head;
        
         
        ListNode newHead = null;;
        ListNode reverseListHead;
        ListNode tail=null;
        
        while(ptr!=null){
            
            int count = 0;
            while(count < k && ptr!=null){
                ptr = ptr.next;
                count++;
            }
            
            if(count == k){
              reverseListHead = reverseLinkedList(head, k);
            
              if(newHead==null)
                    newHead = reverseListHead;
            
               if(tail!=null)
                 tail.next = reverseListHead;
            
            
                tail = head;
                head = ptr;    
            }
             
            
        }
        
        if (tail != null)
               tail.next = head;
        
           return newHead == null ? head : newHead; 
        
    }
    
    public ListNode reverseLinkedList(ListNode head, int k){
        
        ListNode newHead = null;
        ListNode temp;
        ListNode current = head;
        for(int j=0;j<k;j++){
               
            temp  = current;
            current = current.next;
            temp.next =  newHead;
            newHead = temp;     
            
        }
        
        return newHead;
        
    } 
    
    
}