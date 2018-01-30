//Version 1: Traverse
public class Solution {
    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    // 把root为根的inorder加入result里面
    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}
