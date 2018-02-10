/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // [6, 7, 4]
        //    [3, 4]
                                                     
                                                     
        List<ParentTreeNode> PathA = getNode2RootPath(root, A);
        List<ParentTreeNode> PathB = getNode2RootPath(root, B);
        
        int indexA = PathA.size() - 1;
        int indexB = PathB.size() - 1;
        
        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (PathA.get(indexA) != PathB.get(indexB)) {
                break;
            }
            lowestAncestor = PathA.get(indexA);
            indexA--;
            indexB--;
        }
        
        return lowestAncestor;
    }
    
    private List<ParentTreeNode> getNode2RootPath(ParentTreeNode root, ParentTreeNode node) {
        List<ParentTreeNode> result = new ArrayList<>();
        
        result.add(node);
        while(node != root) {
            node = node.parent;
            result.add(node);
        }
        
        return result;
    }
}
