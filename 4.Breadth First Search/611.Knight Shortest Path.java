// Self
/**
 * Definition for a point.
 * public class Point {
 *     public int x, y;
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
        if (grid == null || grid.length == 0 || source == null || destination == null) {
            return -1;
        }
        
        if (grid[source.x][source.y] == true || grid[destination.x][destination.y] == true) {
            return -1;
        }
        
        int[] directX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directY = {2, -2, 2, -2, 1, -1, 1, -1};
        
        int steps = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(source);
        
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                
                for (int j = 0; j < 8; j++) {
                    int x = p.x + directX[j];
                    int y = p.y + directY[j];
                    
                    if (!inBound(x, y, grid)) {
                        continue;
                    }
                    
                    if (grid[x][y] == true) {
                        continue;
                    }
                    
                    if (x == destination.x && y == destination.y) {
                        return steps;
                    }
                    
                    if (grid[x][y] == false) {
                        grid[x][y] = true;
                        q.offer(new Point(x, y));
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
