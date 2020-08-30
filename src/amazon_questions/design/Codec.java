package amazon_questions.design;
//297. Serialize and Deserialize Binary Tree
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

      
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+"#"+left+"#"+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || "".equals(data))
            return null;
        
        String[] nodes = data.split("#");
        Queue<String> queue = new LinkedList(Arrays.asList(nodes));
        return helper(queue);
                
    }
    
  private TreeNode helper(Queue<String> queue){
      String node = queue.poll();
      if(node==null || "X".equals(node))
          return null;
      TreeNode root = new TreeNode(Integer.parseInt(node));
      root.left = helper(queue);
      root.right = helper(queue);
      return root;
  }  
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));