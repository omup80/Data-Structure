package top_questions.medium.linked_list;

import amazon_questions.linked_list.ListNode;
//https://leetcode.com/problems/odd-even-linked-list/
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        int i=1;
        ListNode odd = null, even=null, newHead=null, evenHead=null;
        while(head!=null){
            if(newHead==null){
                newHead = head;
                odd = head;
                head=head.next;
                odd.next=null;
                
            }else if(i%2==0){
                
                  if(evenHead==null){
                      
                      even=head;
                      evenHead = head;
                      head=head.next;
                      even.next=null;
                      
                  }else{
                      even.next=head;
                      even=even.next;
                      head=head.next;
                      even.next=null;
                  }
                      
                   
                   
                    
                       
                    
                
            }else{
                       odd.next = head;
                        odd=odd.next;
                        head=head.next;
                        odd.next=null;
            }
            
            i++;
        }
        
        if(odd!=null)
            odd.next = evenHead;
        
        return newHead;
        
    }
}