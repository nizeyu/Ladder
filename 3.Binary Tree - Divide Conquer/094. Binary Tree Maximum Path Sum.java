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

class ResultType {
    int root2any, any2any;
    public ResultType(int root2any, int any2any) {
        this.root2any = root2any;
        this.any2any = any2any;
    }
}

public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.any2any;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);//因为要舍弃，必须为最小值
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int root2any = Math.max(0, Math.max(left.root2any, right.root2any)) + root.val;
        
        int any2any = Math.max(left.any2any, right.any2any); // root2any 已经帮any2any 做了和0比较的部分
        
        // 容易写成 left.root2any + right.root2any + root.val, root2any 还需要和0比较
        
        any2any = Math.max(any2any, Math.max(0, left.root2any) + Math.max(0, right.root2any) + root.val);
        
        return new ResultType(root2any, any2any);
    }
}
