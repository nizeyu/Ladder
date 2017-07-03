// 九章
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void markByBFS(boolean[][] grid, int x, int y) {
        // magic numbers!
        int[] directionX = {0, 0, -1, 1};
        int[] directionY = {1, -1, 0, 0};
        
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(x, y));
        grid[x][y] = false;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point adj = new Point(
                    p.x + directionX[i],
                    p.y + directionY[i]
                );
                if(!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean inBound(Point p, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        return p.x >= 0 && p.x < n && p.y >= 0 && p.y < m;
    }
}

// 阳沐版
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        int island = 0;
        if (grid.length > 0 && grid[0].length > 0)
        {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                     if (grid[x][y] && !visited[x][y]) {
                         mark_island(x, y, grid, visited);
                         ++island;
                     }
                }
            }
        }
        return island;
    }
    public void mark_island(int sx, int sy, boolean[][] grid, boolean[][] visited) {
        // (x, y) is '1' and not visited

        // BFS - init
        //   start with point (x, y), put it in Q
        Queue<Integer> Qx = new LinkedList<>();
        Queue<Integer> Qy = new LinkedList<>();
        Qx.offer(sx);
        Qy.offer(sy);
        
        // BFS - mainloop
        //   get point P
        //   visit P (mark P as visited)
        //   find neightbours N of P in Q if neightbours not explored and value is '1'
        while (!Qx.isEmpty()) {
            int x = Qx.poll();
            int y = Qy.poll();
            visited[x][y] = true;

            int[] nxs = {x + 1, x - 1, x, x};
            int[] nys = {y, y, y + 1, y - 1};
            for (int i = 0; i < 4; i++) {
                int nx = nxs[i], ny = nys[i];

                if (nx >= 0 && nx < grid.length
                    && ny >= 0 && ny < grid[0].length
                    && grid[nx][ny] && !visited[nx][ny]) {
                        Qx.offer(nx);
                        Qy.offer(ny);
                    }
            }
        }
    }
}
