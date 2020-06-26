package cracking_the_coding_interview.linked_list;


/*

Palindrome: Implement a function to check if a linked list is a palindrome
 */
class Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode previous=null, tempNext=null;
        
        int total = 0;
        
        while(current!=null){
            total++;
            current=current.next;
        }
        
        if(total<=1)
            return true;
        
        current = head;
        
        for(int i=0;i<total/2;i++){
            current = current.next;
        }
       
        
        if(total%2==1){
            
            current = current.next;
            
        }
        
        
        
        boolean isEnd = false;
   
        while(current!=null){
           
            
            tempNext = current.next;//2  3
            current.next = previous;//null   
            previous = current; //1
            current=tempNext;//2
            
                
        } 
        
        
        current = previous;
        
        for(int i=0;i<total/2;i++){
            if(current.val != head.val)
                return false;
            
            current=current.next;
            head=head.next;    
        }
        
        return true;
        
        
        
    } 
}