package mock_test.facebook.oa;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
class FindLargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                max = Math.max(node.val, max);
                if(node.left!=null)
                    q.add(node.left);
                
                if(node.right!=null)
                    q.add(node.right);
            }
            result.add(max);
        }
        
        return result;
    }
}