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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        if (root == null) {
            return results;
        }
        
        dfs(root, "" + root.val, results);
        
        return results;
    }
    
    private void dfs(TreeNode root, String s, List<String> results) {
        if(root.left == null && root.right == null) {
            results.add(new String(s));
        }
        
        if(root.left != null) {
            dfs(root.left, s + "->" + root.left.val, results);
        }
        
        if(root.right != null) {
            dfs(root.right, s + "->" + root.right.val, results);
        }
    }
}
