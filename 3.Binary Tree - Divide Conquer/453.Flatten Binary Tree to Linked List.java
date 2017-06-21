// Version 1: Traverse
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
    public TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(lastNode != null) {
            lastNode.right = root;
            lastNode.left = null;
        }
        
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

// version 2: Divide & Conquer
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
        if(root == null) {
            return;
        }
        
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // Connect leftLast to root.right
        if(leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        // return
        if(rightLast != null) {
            return rightLast;
        }
        
        if(leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
}

// version 3: Non-Recursion
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
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
        
            if(node.right != null) {
                stack.push(node.right);
            }
            
            if(node.left != null) {
                stack.push(node.left);
            }
            
            node.left = null;
            if(!stack.isEmpty()) {
                node.right = stack.peek();
            } else {
                node.right = null;
            }
        }
    }
}

// My Solution: 不优雅
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
