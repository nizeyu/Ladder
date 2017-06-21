// version 1: Traverse + Divide Conquer
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
class ResultType {
    int sum;
    int size;
    ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
} 

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
     
    TreeNode result = null;
    int max = Integer.MIN_VALUE;
    int maxSize = 1;
    public TreeNode findSubtree2(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        ResultType res = getSum(root);
        
        return result;
    }
    
    private ResultType getSum (TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType leftSum = getSum(root.left);
        ResultType rightSum = getSum(root.right);
        
        int sum = leftSum.sum + rightSum.sum + root.val;
        int size = leftSum.size + rightSum.size + 1;
        if(size != 0) {
            if(sum * maxSize > max * size) {
                max = sum;
                maxSize = size;
                result = root;
            }
        }

        return new ResultType(sum, size);
    }
}
