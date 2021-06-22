
//Question Link: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid
import java.util.*;

public class makePathValid {
    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Deque<int[]> dq = new ArrayDeque<>();

        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        dq.add(new int[] { 0, 0, 0 }); // (x,y,cost)

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if (vis[x][y]) // already visited
                continue;

            vis[x][y] = true;
            if (x == m - 1 && y == n - 1) // reached destination
                return cost;

            // process neighbours
            for (int i = 0; i < 4; i++) {
                int dx = x + dirs[i][0];
                int dy = y + dirs[i][1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n)
                    continue;

                // has the appropriate sign,give higher priority
                if (i + 1 == grid[x][y])
                    dq.addFirst(new int[] { dx, dy, cost });
                else
                    dq.addLast(new int[] { dx, dy, cost + 1 });
            }
        }

        return (m - 1) * (n - 1);

    }
}
