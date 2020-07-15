package amazon_questions.linked_list;
import java.util.HashMap;


class CopyListRandomNumberWithHashMap {
    
    
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node getCloneNode(Node node){
        if(node!=null){
            if(visited.containsKey(node)){
                return visited.get(node);
            }else{
                visited.put(node, new Node(node.val));
                return visited.get(node);
                
            }
            
        }
        
        return null;
    }
    
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        
        Node oldNode = head;
        
        Node newNode = getCloneNode(oldNode);
        
        
        
        while(oldNode!=null){
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            
            newNode = newNode.next;
            oldNode = oldNode.next;
            
            
        }
        
        return getCloneNode(head);
        
        
    }
}