// 暴力
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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        
        helper(root, target, 0, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void helper(TreeNode node, int target, int level, List<Integer> buffer, List<List<Integer>> results) {
        if(node == null) {
            return;
        }
        int sum = 0;
        buffer.add(node.val);
        
        for(int i = level; i >= 0; i--) {
            sum += buffer.get(i);
            if(sum == target) {
                List<Integer> temp = new ArrayList<>();
                for(int j = i; j <= level; j++) {
                    temp.add(buffer.get(j));
                }
                results.add(new ArrayList<>(temp));
            }
        }
        
        helper(node.left, target, level+1, buffer, results);
        helper(node.right, target, level+1, buffer, results);
        
        buffer.remove(buffer.size()-1);
    }
}
