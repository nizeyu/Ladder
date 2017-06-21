// version 1 : traverse + divide conquer
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

// version 2: Pure divide conquer
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
    int sum, miniSum;
    TreeNode miniRoot;
    ResultType(int sum, int miniSum, TreeNode miniRoot) {
        this.sum = sum;
        this.miniSum = miniSum;
        this.miniRoot = miniRoot;
    }
} 

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        ResultType res = helper(root);
        
        return res.miniRoot;
    }
    
    private ResultType helper(TreeNode node) {
        if(node == null) {
            return new ResultType(0, Integer.MAX_VALUE, null);
        }
        
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        
        int s = left.sum + right.sum + node.val;
        int m = Math.min(left.miniSum, right.miniSum);
        TreeNode miniNode = null;
        if(left.miniSum < right.miniSum) {
            miniNode = left.miniRoot;
        } else {
            miniNode = right.miniRoot;
        }
        
        if(s < m) {
            m = s;
            miniNode = node;
        }
        
        return new ResultType(s, m, miniNode);
    }
}





