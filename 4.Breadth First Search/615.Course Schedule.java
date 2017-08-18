public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0 || numCourses == 0) {
            return true;
        }
        
        List[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        int n = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                n++;
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int e = (int)edges[course].get(i);
                indegree[e]--;
                if (indegree[e] == 0) {
                    n++;
                    q.offer(e);
                }
            }
        }
        
        return n == numCourses;
    }
}
