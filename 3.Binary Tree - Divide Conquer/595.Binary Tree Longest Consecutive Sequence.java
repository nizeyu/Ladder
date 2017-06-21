// version 1: Traverse + Divide Conquer
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }
    
    private int helper(TreeNode node, TreeNode parent, int curLength) {
        if(node == null) {
            return 0;
        }
        
        int length = 1;
        if(parent != null && parent.val + 1 == node.val) {
            length = curLength + 1;
        }
        
        int maxLeft = helper(node.left, node, length);
        int maxRight = helper(node.right, node, length);
        
        return Math.max(length, Math.max(maxLeft, maxRight));
    }
}
