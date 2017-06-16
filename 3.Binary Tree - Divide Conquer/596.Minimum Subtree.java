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
     * @return the root of the minimum subtree
     */
    int min = Integer.MAX_VALUE;
    TreeNode result = null;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null) {
            return root;
        }
        
        //TreeNode result = null;
        
        int res = getSum(root);
        //System.out.println(res);
        
        return result;
    }
    
    private int getSum (TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getSum(root.left);
        //System.out.println(left);
        int right = getSum(root.right);
        
        int sum = left + right + root.val;
        //System.out.println(sum);
        if(sum < min) {
            min = sum;
            result = root;
        }

        return sum;
    }
}
