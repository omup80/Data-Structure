package cracking_the_coding_interview.linked_list;


 // Definition for singly-linked list.


class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null){
            head=null;
            return head;
        }
        
        ListNode frontPointer = head;
        ListNode backPointer = head;
        boolean flag = false;
        for(int i=0;i<n;i++){
                
            if(frontPointer.next==null){
                    flag=true;
                    break;
                }
            
            frontPointer = frontPointer.next;
                
                    
        }
        
        if(flag){
            head = backPointer.next; 
            backPointer= null;
            return head;
        }
        
        
        while(frontPointer.next !=null){
            backPointer = backPointer.next;
            frontPointer = frontPointer.next;
        }
        
        
          
          frontPointer = backPointer.next;
          backPointer.next = frontPointer.next;
          frontPointer=null;    
        
        
        
        return head;
        
    }
}