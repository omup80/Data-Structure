package top_questions.medium.tree_and_graph;/*
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

class ConnectNextPointer {
    /*
    public Node connect(Node root) {
        if(root==null || (root.left==null && root.right==null))
            return root;
        
        root.left.next = root.right;
        connect(root.left, root.right);
        return root;
    }
    private void connect(Node t1, Node t2){
        if(t1==null && t2==null)
            return;
        if(t1.left!=null)
          t1.left.next=t1.right;
        if(t1.right!=null)
          t1.right.next = t1.next.left;
       if(t2.left!=null)
        t2.left.next = t2.right;
        
       if(t2.right!=null)
           t2.right.next = t2.next!=null?t2.next.left:t2.next;
        connect(t1.left, t1.right);
        connect(t2.left, t2.right);
        
    }

     */
}