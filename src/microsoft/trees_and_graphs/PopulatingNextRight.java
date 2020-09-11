package microsoft.trees_and_graphs;
// Definition for a Node.
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//116. Populating Next Right Pointers in Each Node
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class PopulatingNextRight {
    
    public Node connect(Node root) {
      Node leftNode=root;   
      while(leftNode!=null){
          createLink(leftNode);
          leftNode = leftNode.left;
          
      }
      return root;  
    }
    
    private void createLink(Node leftNode){
        
        while(leftNode!=null && leftNode.left!=null){
           leftNode.left.next = leftNode.right;
           if(leftNode.next!=null) 
                leftNode.right.next=leftNode.next.left ;
           leftNode = leftNode.next; 
        }
        
        
        
    }
}