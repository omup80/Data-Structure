package amazon_questions.mock.onsite;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AverageOfLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         q.add(root);
         while(!q.isEmpty()){
             int size = q.size();
             Double sum=0.0;
             for(int i=0;i<size;i++){
                 TreeNode node = q.remove();
                 sum += node.val;
                 if(node.left!=null)
                     q.add(node.left);
                 
                 if(node.right!=null)
                     q.add(node.right);
                 
                 
             }
             result.add(sum/size);
             
         }
        
        return result;
    }
}