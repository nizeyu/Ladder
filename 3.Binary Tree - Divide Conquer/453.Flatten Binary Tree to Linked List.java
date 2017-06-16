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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        if(root.right != null) {
            stack.push(root.right);
        }
        if(root.left != null) {
            stack.push(root.left);
        }
        
        TreeNode p = root;
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
        
            if(node.right != null) {
                stack.push(node.right);
            }
            
            if(node.left != null) {
                stack.push(node.left);
            }
            
            p.right = node;
            p.left = null;
            p = p.right;
        }
    }
}
