package amazon_questions.linked_list;

/*

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */

class AddTwoNumber {
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