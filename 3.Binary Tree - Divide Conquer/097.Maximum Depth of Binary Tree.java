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
    private int maxDepth;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        
        maxDepth = 0;
        getDepth(root, 1);
        
        return maxDepth;
    }
    
    private void getDepth(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        
        if (curDepth > maxDepth) {
            maxDepth = curDepth;
        }
        
        getDepth(root.left, curDepth + 1);
        getDepth(root.right, curDepth + 1);
    }
}
