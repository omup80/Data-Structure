package microsoft.linked_list;
//206. Reverse Linked List
//https://leetcode.com/problems/reverse-linked-list/



class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous=null, current=null, next=null;
        current=head;
        
        while(current!=null){
           next = current.next;
           current.next = previous;
           previous = current;   
           current = next;
            
        }
       return previous; 
    }
}