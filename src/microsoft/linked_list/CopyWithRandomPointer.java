package microsoft.linked_list;

import java.util.HashMap;

// Definition for a Node.
//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/
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


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copies = new HashMap<Node, Node>();
        Node ptr = head;
        while(ptr!=null){
            copies.put(ptr, getCopy(ptr));
            ptr=ptr.next;
        }
        ptr=head;
        Node deepCopyHead =null;
        Node copyPtr=null;
        while(ptr!=null){
            if(deepCopyHead==null){
                deepCopyHead = copies.get(ptr);
                deepCopyHead.random = copies.get(ptr.random);
                copyPtr = deepCopyHead;
                ptr = ptr.next;
            }else{
                copyPtr.next = copies.get(ptr);
                copyPtr.next.random = copies.get(ptr.random);
                copyPtr = copyPtr.next;
                ptr = ptr.next;
            }
        }
        copyPtr = deepCopyHead;
      
        return deepCopyHead;
    }
    private Node getCopy(Node node){
        if(node==null)
            return null;
        Node copy = new Node(node.val);
        return copy;
    }
}