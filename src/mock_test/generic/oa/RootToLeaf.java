package mock_test.generic.oa;

import amazon_questions.trees_and_graph.TreeNode;
//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
class RootToLeaf {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        traverseTree(root, "");
        return sum;
    }
    private void traverseTree(TreeNode root, String binary){
        
        binary = binary+""+root.val;
        if(root.left==null && root.right==null)
            calculateSum(binary);
        if(root.left!=null)
            traverseTree(root.left, binary);
        
        if(root.right!=null)
            traverseTree(root.right, binary);
    }
    private void calculateSum(String binary){
        int power=1;
        int index = binary.length()-1;
        int currentSum=0;
        while(index>=0){
            char c = binary.charAt(index);
            currentSum+=(c-'0')*power;
            power = power*2;
            index--;
        }
        sum += currentSum;
    }
}