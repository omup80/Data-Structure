package microsoft.design;


import java.util.ArrayList;
import java.util.List;

//* Definition for a binary tree node.
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
            return "";
        StringBuilder s =  serialiseHelper(root);
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }
    
    private StringBuilder serialiseHelper(TreeNode root){
        if(root==null)
            return new StringBuilder();
        StringBuilder s = new StringBuilder();
        s.append(root.val).append(",");
        s.append(serialiseHelper(root.left));
        s.append(serialiseHelper(root.right));
        
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data=="")
            return null;
        
        List<Integer> preorder = new ArrayList<Integer>();
        for(String value: data.split(",")){
            preorder.add(Integer.parseInt(value));
        }
        
        return deserializeHelper(preorder, 0, preorder.size()-1);
    }
    
    private TreeNode deserializeHelper(List<Integer> preorder, int low,int high){
            if(low>high)
                return null;
            int val = preorder.get(low);
            TreeNode root = new TreeNode(val);
            int index = getDividingIndex(preorder, low+1, high, val);
            root.left = deserializeHelper(preorder, low+1, index);
            root.right = deserializeHelper(preorder, index+1, high);
            return root;
       
        
    }
    
   private int getDividingIndex(List<Integer> preorder,int low,int high,int val){
       int i=low;
       while(i<= high && val>preorder.get(i)){
           i++;
       }
       return i-1;
   } 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));