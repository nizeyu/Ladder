// Self
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> results = new ArrayList<DirectedGraphNode>();
        
        int[] indegree = new int[graph.size()];
        
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                indegree[neighbor.label]++;
            }
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        
        for (DirectedGraphNode node : graph) {
            if (indegree[node.label] == 0) {
                q.offer(node);
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            results.add(node);
            
            for(DirectedGraphNode neighbor : node.neighbors) {
                indegree[neighbor.label]--;
                
                if (indegree[neighbor.label] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return results;
    }
}
