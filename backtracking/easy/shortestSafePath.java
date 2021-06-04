//Given a MxN matrix,having cells marked as 0 as landmines
//Find the shortest safe path from the first column to the last column
//Note: landmines and cells adjacent to landmines are unsafe

public class shortestSafePath {
    static int[] ROWS = { -1, 0, 0, 1 };
    static int[] COLS = { 0, -1, 1, 0 };

    static int min_dist = Integer.MAX_VALUE;

    public static int minPathLength(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] visited = new boolean[r][c];

        // mark cells adjacent to landmines as unsafe
        markUnsafe(mat);

        // start finding shortest path from first col
        for (int i = 0; i < r; i++) {
            if (mat[i][0] == 1) {
                // initialze visited to false
                for (int k = 0; k < r; k++)
                    Arrays.fill(visited[k], false);
                findShortestPath(mat, visited, i, 0, 0);
                if (min_dist == c - 1)
                    break;
            }
        }

        return min_dist;

    }

    // mark adjacent cells of landmines as unsafe
    private static void markUnsafe(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        if (isValid(i + ROWS[k], j + COLS[k], mat))
                            mat[i + ROWS[k]][j + COLS[k]] = -1;
                    }
                }
            }

        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1)
                    mat[i][j] = 0;
            }
        }
    }

    // check if safe and not yet visited
    private static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
        if (mat[x][y] == 0 || visited[x][y])
            return false;

        return true;

    }

    // bounds check
    private static boolean isValid(int x, int y, int[][] mat) {
        if (x < mat.length && x >= 0 && y < mat[0].length && y >= 0)
            return true;

        return false;
    }

    private static void findShortestPath(int[][] mat, boolean[][] visited, int i, int j, int dist) {
        // reached destination
        if (j == mat[0].length - 1) {
            min_dist = Math.min(min_dist, dist);
            return;
        }

        if (dist > min_dist)
            return; // prune

        visited[i][j] = true; // add to path

        for (int k = 0; k < 4; k++) {
            if (isValid(i + ROWS[k], j + COLS[k], mat) && isSafe(mat, vis, i + ROWS[k], j + COLS[k])) {
                findShortestPath(mat, visited, i + ROWS[k], j + COLS[k], 1 + dist);
            }

        }
        visited[i][j] = false; // backtrack
    }
}
