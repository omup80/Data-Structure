package top_questions.medium.design;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String ans= sHelper(root, "");
        return ans.substring(1);
    }
    
    private String sHelper(TreeNode root, String s){
        if(root==null){
            s += ",n";
        }else{
            s += ","+String.valueOf(root.val);
            s = sHelper(root.left, s);
            s = sHelper(root.right, s);
        }
        
        return s;
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataNodes = data.split(",");
        List<String> nodes = new ArrayList<String>(Arrays.asList(dataNodes));
        return dHelper(nodes);
    }
    
    private TreeNode dHelper(List<String> nodes){
        if(nodes.get(0).equals("n")){
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = dHelper(nodes);
        root.right = dHelper(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));