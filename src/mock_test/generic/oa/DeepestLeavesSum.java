package mock_test.generic.oa;

import amazon_questions.trees_and_graph.TreeNode;

class DeepestLeavesSum {
    int max=0;
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        findMaxHeight(root, 0);
        calculateSum(root, 0);
        return sum;
    }
    private void calculateSum(TreeNode node, int height){
        if(node==null)
            return;
        height++;
        if(height==max)
            sum += node.val;
        calculateSum(node.left, height);
        calculateSum(node.right, height);
        
        
    }
    private void findMaxHeight(TreeNode node, int height){
        if(node==null)
            return;
        
            height++;
            max = Math.max(height, max);
            findMaxHeight(node.left, height);
            findMaxHeight(node.right, height);

    }
}