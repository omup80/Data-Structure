package top_questions.medium.linked_list;

import amazon_questions.linked_list.ListNode;

//https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null, l3=null;
        int carry=0;
        while(l1!=null || l2!=null ){
            int v1=(l1==null)?0:l1.val;
            int v2 =(l2==null)?0:l2.val;
            if(result==null){
                
                result = new ListNode((v1+v2)%10);
                carry=(v1+v2)/10;
                l3=result;
                
            }else{
                l3.next = new ListNode((v1+v2+carry)%10);
                carry=(v1+v2+carry)/10;
                l3=l3.next;
            }
            
            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
        }
        
        if(carry>0){
            l3.next = new ListNode(carry);
        }
        return result;
    }
}