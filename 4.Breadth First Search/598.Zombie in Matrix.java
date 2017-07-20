class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
     
    public int WALL = 2;
    public int ZOMBIE = 1;
    public int PEOPLE = 0;
    
    public int[] deltaX = {-1, 1, 0, 0};
    public int[] deltaY = {0, 0, -1, 1};
    
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Queue<Point> q = new LinkedList<>();
        int people = 0;
        
        // initialize the queue & count people
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                } else if (grid[i][j] == ZOMBIE) {
                    q.offer(new Point(i, j));
                }
            }
        }
        
        // corner case
        if (people == 0) {
            return 0;
        }
        
        // bfs
        int days = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            days++;
            
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    Point t = new Point(p.x + deltaX[j], p.y + deltaY[j]);
                    
                    if (!inBound(t, grid)) {
                        continue;
                    }
                    
                    if (grid[t.x][t.y] != PEOPLE) {
                        continue;
                    }
                    
                    grid[t.x][t.y] = ZOMBIE;
                    people--;
                    
                    if (people == 0) {
                        return days;
                    }
                    
                    q.offer(t);
                }
            }
        }
        
        return -1;
    }
    
    
    private boolean inBound(Point p, int[][] grid) {
        if (p.x < 0 || p.x >= grid.length || p.y < 0 || p.y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
