package top_questions.hard.linked_list;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.

//https://leetcode.com/problems/copy-list-with-random-pointer/
class CopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        makeCopies(head, map);
        Node ptr = head;
        while(ptr!=null){
            Node node = map.get(ptr);
            node.next = map.get(ptr.next);
            node.random = map.get(ptr.random);
            ptr=ptr.next;
        }
        return map.get(head);
    }
    
    private void makeCopies(Node head, Map<Node, Node> map){
        while(head!=null){
            Node copy = new Node(head.val);
            map.put(head, copy);
            head=head.next;
        }
    
    }

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

}