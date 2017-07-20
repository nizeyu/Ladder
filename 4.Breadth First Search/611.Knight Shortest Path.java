/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
        
        int distance = 0;
        Queue<Point> q = new LinkedList<>();
        
        q.offer(source);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                
                if (p.x == destination.x && p.y == destination.y) {
                    return distance;
                }
                
                for (int j = 0; j < 8; j++) {
                    Point t = new Point(p.x + deltaX[j], p.y + deltaY[j]);
                    
                    if (!inBound(t, grid)) {
                        continue;
                    }
                    
                    if (!grid[t.x][t.y]) {
                        // mark the point not accessible
                        grid[t.x][t.y] = true;
                        q.offer(t);
                    }
                }
            }
            
            distance++;
        }
        
        return -1;
    }
    
    private boolean inBound(Point p, boolean[][] grid) {
        if (p.x < 0 || p.x >= grid.length || p.y < 0 || p.y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
