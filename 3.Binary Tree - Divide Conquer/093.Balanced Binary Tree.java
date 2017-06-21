// Version 1: with ResultType
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
    int depth;
    boolean isBalanced;
    ResultType(int depth, boolean isBalanced) {
        this.depth = depth;
        this.isBalanced = isBalanced;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        
        ResultType result = getDepth(root);
        
        return result.isBalanced;
    }
    
    private ResultType getDepth(TreeNode root) {
        if(root == null) {
            return new ResultType(0, true);
        }
        
        ResultType left = getDepth(root.left);
        ResultType right = getDepth(root.right);
        
        ResultType res = new ResultType(Math.max(left.depth, right.depth) + 1, true);
        
        // subtree not balance
        if(left.isBalanced == false || right.isBalanced == false) {
            res.isBalanced = false;
        }
        
        // root not balance
        if(Math.abs(left.depth - right.depth) > 1) {
            res.isBalanced = false;
        }
        
        return res;
    }
}

// Version 2: without ResultType
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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        
        if(getDepth(root) == -1) {
            return false;
        }
        
        return true;
    }
    
    private int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        
        if(leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        
        if(Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
