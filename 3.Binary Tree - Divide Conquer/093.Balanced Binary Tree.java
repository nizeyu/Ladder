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
