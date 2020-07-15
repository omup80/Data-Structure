package amazon_questions.linked_list;

/**
 Merge k sorted linked lists and return it as one sorted list.
 Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]

 Output: 1->1->2->3->4->4->5->6
 */
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        
        int amount = lists.length;
        int interval = 1;
        
        while(interval < amount){
            
            for(int i=0; i< amount-interval;i= i+ interval*2){
                
                lists[i] = merge2List(lists[i], lists[i+interval]);
                
                
            }
            interval = interval * 2;
            
        }
        
        return  amount>0 ? lists[0]: null;
        
    }
    
    public ListNode merge2List(ListNode list1, ListNode list2){
        
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        
        while(list1 !=null && list2 !=null){
            
            if(list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = list1==null ? list2:list1;
        
        return preHead.next;
        
        
    }
}