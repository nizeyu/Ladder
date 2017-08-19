// Self
// Version 1: Divide Conquer
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// version 2: Traverse
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
     * @return: An integer.
     */
    public int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;
        helper(root, 1);
        return depth;
    }
    
    private void helper(TreeNode node, int curDepth) {
        if(node == null) {
            return;
        }
        
        if(curDepth > depth) {
            depth = curDepth;
        }
        
        helper(node.left, curDepth + 1);
        helper(node.right, curDepth + 1);
    }
}
