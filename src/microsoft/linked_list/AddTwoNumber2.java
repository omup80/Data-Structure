package microsoft.linked_list;

import java.util.Stack;

//445. Add Two Numbers II
//https://leetcode.com/problems/add-two-numbers-ii/
class AddTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
     ListNode head = new ListNode(0);   
     while(!s1.isEmpty() || !s2.isEmpty()){
         int sum=0;
         sum += (s1.isEmpty()? 0: s1.pop());
         sum += (s2.isEmpty()? 0: s2.pop());
         ListNode node = new ListNode((head.val+sum)/10);
         head.val= (head.val+sum)%10;
         
         node.next = head;
         head = node;
     }   
      return head.val==0?head.next:head;
    }
}