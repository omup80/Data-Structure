package microsoft.linked_list;

class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null, ptr=null;
        int sum=0;
        int carry=0;
        while(l1!=null || l2!=null){
            int val1 = (l1==null?0:l1.val);
            int val2 = (l2==null?0:l2.val);
            sum = (val1+val2+carry)%10;
            carry = (val1+val2+carry)/10;   
            if(result==null){
                result = new ListNode(sum);
                ptr=result;
            }else{
                ptr.next = new ListNode(sum);
                ptr=ptr.next;
            }
            l1=(l1!=null? l1.next:null);
            l2=(l2!=null? l2.next:null);
        }
        if(carry!=0)
            ptr.next = new ListNode(carry);
        
        return result;
        
    }
}