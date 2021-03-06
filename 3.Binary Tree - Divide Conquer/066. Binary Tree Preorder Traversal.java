//Version 1: Traverse
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    // 把root为根的preorder加入result里面
    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}

//Version 2: Divide & Conquer
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // null or leaf
        if (root == null) {
            return result;
        }
        
        // Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
}

