/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // copy nodes, store the old->new mapping information in a hash map
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        q.offer(node);
        set.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode head = q.poll();
            
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    q.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
