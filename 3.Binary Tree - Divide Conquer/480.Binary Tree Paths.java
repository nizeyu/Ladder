// version 1: Divide Conquer
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
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for(String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        
        for(String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        if(paths.size() == 0) {
            paths.add(String.valueOf(root.val));
        }
        
        return paths;
    }
}

// version 2: traverse
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
        List<String> results = new ArrayList<String>();
        if (root == null) {
            return results;
        }
        
        dfs(root, String.valueOf(root.val), results);
        
        return results;
    }
    
    private void dfs(TreeNode node, String path, List<String> results) {
        if(node == null) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            results.add(new String(path));
        }
        
        if(node.left != null) {
            dfs(node.left, path + "->" + String.valueOf(node.left.val), results);
        }
        
        if(node.right != null) {
            dfs(node.right, path + "->" + String.valueOf(node.right.val), results);
        }
    }
}
