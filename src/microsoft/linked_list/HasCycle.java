package microsoft.linked_list;

//https://leetcode.com/problems/linked-list-cycle/submissions/
//141. Linked List Cycle
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slowRunner = head;
        ListNode fastRunner = head.next;
        
        while(slowRunner!=null && fastRunner!=null){
            slowRunner = slowRunner!=null ? slowRunner.next:null;
            fastRunner = fastRunner!=null && fastRunner.next!=null? fastRunner.next.next: null;
            if(slowRunner==fastRunner)
                return true;
        }
        
        return false;
    }
}