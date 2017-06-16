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
     * @return: True if the binary tree is BST, or false
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        
        if(root.left == null && root.right == null) {
            return true;
        }
        
        return inOrder(root);
    }
    
    private boolean inOrder (TreeNode root) {
        if(root == null) {
            return true;
        }
        
        boolean left = inOrder(root.left);
        if(root.val <= pre) {
            return false;
        }
        pre = (long)root.val;
        boolean right = inOrder(root.right);
        
        if(left == false || right == false) {
            return false;
        }
        
        return true;
    }
}
