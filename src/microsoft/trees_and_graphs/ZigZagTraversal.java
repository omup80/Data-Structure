package microsoft.trees_and_graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//103. Binary Tree Zigzag Level Order Traversal
class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        left.add(root);
        while(!left.isEmpty()){
            List<Integer> leftTraversal = new ArrayList<Integer>();
            while(!left.isEmpty()){
                TreeNode node = left.pop();
                leftTraversal.add(node.val);
                if(node.left!=null)
                    right.add(node.left);
                if(node.right !=null)
                    right.add(node.right);
            }
            result.add(leftTraversal);
            List<Integer> rightTraversal = new ArrayList<Integer>();    
            
            while(!right.isEmpty()){
                TreeNode node = right.pop();
                rightTraversal.add(node.val);
                
                if(node.right !=null)
                    left.add(node.right);
                
                if(node.left!=null)
                    left.add(node.left);
            }
            
            if(rightTraversal.size()>0)
                result.add(rightTraversal);
            
        }
        return result;
    }
}