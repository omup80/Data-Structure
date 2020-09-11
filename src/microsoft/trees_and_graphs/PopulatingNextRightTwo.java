package microsoft.trees_and_graphs;/*
// Definition for a Node.
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
*/

class PopulatingNextRightTwo {
    
    Node prev, leftMost;
    public Node connect(Node root) {
        if(root==null)
            return root;
        
        leftMost = root;
        Node cur;
        while(leftMost!=null){
            
            cur = leftMost;
            leftMost = null;
            prev = null;
            while(cur!=null){
                createLink(cur.left);
                createLink(cur.right);
                cur = cur.next;
            }
            
            
        }
        
        return root;
        
    }
    
    private void createLink(Node node){
        if(node!=null){
            if(prev!=null){
                prev.next = node;
            }else{
                leftMost = node;
            }
            
            prev = node;
        }
    }
}