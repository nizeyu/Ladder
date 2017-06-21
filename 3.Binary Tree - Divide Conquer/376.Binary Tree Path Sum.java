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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        
        List<Integer> path = new ArrayList<Integer>(); 
        path.add(root.val);
        dfs(root, target, root.val, path, results);

        return results;
    }
    
    private void dfs(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> results) {
        // meet leaf
        if(root.left == null && root.right == null && sum == target) {
            results.add(new ArrayList<>(path));
        }
        
        // go left
        if(root.left != null) {
            path.add(root.left.val);
            dfs(root.left, target, sum + root.left.val, path, results);
            path.remove(path.size() - 1);
        }
        
        // go right
        if(root.right != null) {
            path.add(root.right.val);
            dfs(root.right, target, sum + root.right.val, path, results);
            path.remove(path.size() - 1);
        }
    }
}
