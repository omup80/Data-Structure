package google.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//315. Count of Smaller Numbers After Self
 class Node{
        Node left;
        Node right;
        int val;
        int lessThan;
        
        public Node(int val, int lessThan){
            left=null;
            right=null;
            this.val=val;
            this.lessThan = lessThan;
        }
    }
class CountSmaller {
    Integer[] result ;
    int index;
    
    public List<Integer> countSmaller(int[] nums) {
        Node root= null;
        
        if(nums==null)
            return new ArrayList<Integer>();
        
        result = new Integer[nums.length];
        index = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            root = insert(root, nums[i], 0);
        }
        
        return Arrays.asList(result);
        
    }
    private Node insert(Node root, int val, int sum){
        if(root==null){
            result[index--] = sum; 
            return new Node(val, 0);
        }
        
        if(val<root.val){
            root.lessThan++;
            root.left = insert(root.left, val, sum);
        }else{
            if(val!=root.val){
                root.right = insert(root.right, val, sum+root.lessThan+1);
            }else{
                root.right = insert(root.right, val, sum+root.lessThan);
            }
        }
        
        return root;
    }
    
}