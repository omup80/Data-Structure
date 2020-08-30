package amazon_questions.design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>(capacity);
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null)
            return -1;
        remove(node);
        add(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node==null){
            if(map.size()==capacity){
                int k = tail.prev.key;
                map.remove(k);
                remove(tail.prev);
            }
            node = new Node();
            node.key = key;
            node.value = value;
        }else{
            node.value = value;
            remove(node);
        }
        
       
       
       map.put(key, node);
       add(node); 
    }
    
    private void add(Node node){
        Node next_node = head.next;
        head.next = node;
        node.prev = head;
        next_node.prev = node;
        node.next = next_node;
    }
    
    private void remove(Node node){
       Node prev_node = node.prev;
       Node next_node = node.next;
       prev_node.next = next_node;
       next_node.prev = prev_node; 
    }
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */