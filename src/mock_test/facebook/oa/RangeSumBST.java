package mock_test.facebook.oa;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/nested-list-weight-sum-ii/
class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> numbers = new ArrayList<Integer>();
        createList(root, numbers);
        Integer left=0;
        while(left<numbers.size() && numbers.get(left)<low)
            left++;
        Integer right=left;
        int sum=0;
        while(right<numbers.size() && numbers.get(right)<=high)
            sum += numbers.get(right++);
        
        return sum;
    }
    private void createList(TreeNode root, List<Integer> numbers){
        if(root==null)
            return;
        
        if(root.left!=null)
            createList(root.left, numbers);
        numbers.add(root.val);
        if(root.right!=null)
            createList(root.right, numbers);
        
        
        
    }
}