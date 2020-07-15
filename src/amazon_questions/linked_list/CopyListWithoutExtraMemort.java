package amazon_questions.linked_list;/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyListWithoutExtraMemort {
    
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Node ptr = head;
        
        //created the dublicated just aside of the original nodes    
        while(ptr!=null){
            
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
            
        }
        
        //set the random in duplicate list
        //printList(head);

        ptr = head;
        Node newPtr = ptr.next;
        
        while(ptr!=null){
            
           ptr.next.random = (ptr.random ==null)?null: ptr.random.next;
           ptr = ptr.next.next; 
        
        }
        
        
      //extract new list
      
      
      
        newPtr = head.next;
        Node oldPtr = head;  
        Node newHead = head.next;
        
        while(oldPtr !=null){
          
          oldPtr.next = oldPtr.next.next;
          newPtr.next = (newPtr.next != null ) ? newPtr.next.next : null;
          oldPtr = oldPtr.next;
          newPtr = newPtr.next;
          
        }
       
     // printList(head);  
      return newHead;  
    
        
    }
    public void printList(Node node){
        Node ptr = node;
        while(ptr!=null){
            System.out.print("["+ptr.val+","+ (ptr.random!=null?ptr.random.val:null)+"],");
            ptr = ptr.next;
        }
    }
}