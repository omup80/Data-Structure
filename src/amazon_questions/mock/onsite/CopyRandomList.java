package amazon_questions.mock.onsite;

import java.util.HashMap;
import java.util.Map;

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


class CopyRandomList {
    Map<Node, Node> map = new HashMap(); ;
    
    public Node copyRandomList(Node head) {
        createMapping(head);
        Node ptr = head;
        Node newHead=null;
        Node newPtr=null;
        while(ptr!=null){
            if(newHead==null){
                newHead = map.get(ptr);
                newHead.random = map.get(ptr.random);
                newPtr = newHead;
                ptr = ptr.next;
            }else{
                newPtr.next = map.get(ptr);
                newPtr.next.random = map.get(ptr.random);
                newPtr = newPtr.next;
                ptr=ptr.next;
            }
        }
        
        return newHead;
    }
    
    private void createMapping(Node head){
        while(head!=null){
            Node node = new Node(head.val);
            map.put(head, node);
            head = head.next;
        }
    }
        
}