package amazon_questions.mock.telephonic_interview;

import amazon_questions.linked_list.ListNode;

class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result=null;
        ListNode ptr=null;
        int sum=0;
        int carry=0;
        while(l1!=null && l2!=null){
            if(result==null){
                result = new ListNode((l1.val+l2.val+carry)%10);
                carry = (l1.val+l2.val+carry)/10;
                ptr=result;
                
            }else{
                ptr.next = new ListNode((l1.val+l2.val+carry)%10);
                carry = (l1.val+l2.val+carry)/10;
                ptr=ptr.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
                ptr.next = new ListNode((l1.val+carry)%10);
                carry = (l1.val+carry)/10;
                ptr=ptr.next;
                l1=l1.next;
        }
        
        while(l2!=null){
               ptr.next = new ListNode((l2.val+carry)%10);
                carry = (l2.val+carry)/10;
                ptr=ptr.next;
                l2=l2.next;
        }
        
        if(carry!=0){
            ptr.next = new ListNode(carry);
        }
        
        return result;
        
    }
}