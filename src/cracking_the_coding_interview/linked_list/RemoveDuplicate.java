package cracking_the_coding_interview.linked_list;

import java.util.HashMap;

// The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class RemoveDuplicate
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
     HashMap<Integer, Boolean> present = new HashMap<Integer, Boolean>();
     if(head.next == null)
        return head;
     Node iterator = head.next;
     Node previous = head;
     
     present.put(previous.data, true);
     
     while(previous.next != null){
         Boolean isPresent = present.get(iterator.data);
         if(isPresent == null){
             present.put(iterator.data, true);
             iterator = iterator.next;
             previous = previous.next;
         }else if(isPresent == true){
             if(iterator.next==null){
               previous.next = null;
               iterator = null;
             }else{
               iterator = iterator.next;
               previous.next.next = null;
               previous.next = iterator;    
             }
             
             
             
         }
         
     }
     
     
     return head;

    }
}
