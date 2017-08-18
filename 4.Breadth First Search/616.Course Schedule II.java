// Self
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }
        
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            int[] r = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                r[i] = i;
            }
            return r;
        }
        
        List<Integer> result = new ArrayList<>();
        
        List[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int n = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                n++;
                q.offer(i);
                result.add(i);
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
                    result.add(e);
                    q.offer(e);
                }
            }
        }
        
        if (n != numCourses) {
            //System.out.println(n);
            return new int[]{};
        }
        
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}

// Lintcode
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
