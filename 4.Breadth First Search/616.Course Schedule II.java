public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] edges = new List[numCourses];
        int[] indegree = new int[numCourses];
        
        // build graph
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        int[] order = new int[numCourses];
        
        while (!q.isEmpty()) {
            int course = q.poll();
            order[count++] = course;
            
            for (int i = 0; i < edges[course].size(); i++) {
                int edge = (int)edges[course].get(i);
                indegree[edge]--;
                
                if (indegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }
        
        if (count == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}
