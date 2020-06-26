package cracking_the_coding_interview.linked_list;




/*

Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
 */
class SumLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    
        int carry=0;
        ListNode l3=null;
        ListNode l3Head = null;
        
        while(l1!=null || l2!=null){
            
             if(l3==null){
                 l3 = new ListNode();
                 l3Head = l3;
             }else{
                 l3.next = new ListNode();
                 l3 = l3.next;
             }
              if(l1==null){
                l3.val =   (l2.val + carry)%10;
                carry = (l2.val +carry)/10;
                   
              }else if(l2==null){
                l3.val =   (l1.val + carry)%10;
                carry = (l1.val +carry)/10;
                
              }else{
               
                l3.val = (l1.val + l2.val+carry)%10;
                carry = (l1.val + l2.val+carry)/10;
                  
              }
              
             
            if(l1!=null)
                l1 = l1.next;
             
             if(l2 != null) 
               l2 = l2.next;
            
        }
        
        if(carry>0){
            l3.next = new ListNode(carry);
        }  
            
            
        return l3Head;
                
        
    }
}