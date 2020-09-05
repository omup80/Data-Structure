package microsoft.linked_list;

//https://leetcode.com/problems/merge-k-sorted-lists/
//23. Merge k Sorted Lists
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        int amount = lists.length;
        int interval = 1;
        
        while(interval<amount){
            
            for(int i=0;i<amount-interval;i=i+interval*2){
              lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval = interval*2;
        }
        
        return lists[0];
        
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(l1!=null || l2!=null){
            
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    ptr.next=l1;
                    l1=l1.next;
                    ptr=ptr.next;
                    
                }else{
                    ptr.next=l2;
                    l2=l2.next;
                    ptr=ptr.next;
                }
            }else if(l1!=null){
                ptr.next = l1;
                break;
            }else{
                ptr.next = l2;
                break;
            }
            
            
            
        }
        return dummy.next;
    }
}