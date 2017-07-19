/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        q.offer(node);
        set.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode head = q.poll();
            
            if (values.get(head) == target) {
                return head;
            }
            
            for (UndirectedGraphNode n : head.neighbors) {
                if (!set.contains(n)) {
                    q.offer(n);
                    set.add(n);
                }
            }
        }
        
        return null;
    } 
}
