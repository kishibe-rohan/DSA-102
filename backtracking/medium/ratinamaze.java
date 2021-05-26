//Given a NxN 2D array,a rat starts at (0,0)
//It can move to  a cell if it has the value '1' (open) 
//Find all possible paths for the rat to reach bottom right end of maze(N-1,N-1)

public class ratinamaze {
    public static ArrayList<String> main(int[][] m, int n) {
        ArrayList<String> paths = new ArrayList<String>();
        String path = "";
        if (m[0][0] == 1)
            solve(m, n, 0, 0, path, paths);

        return paths;
    }

    private static void solve(int[][] m, int n, int row, int col, String path, ArrayList<String> paths) {
        // boundary and visited check
        if (row >= n || col >= n || row < 0 || col < 0 || m[row][col] == 2)
            return;

        // valid path...add to results
        if (row == n - 1 && col == n - 1)
            paths.add(path);

        m[row][col] = 2; // mark as visited

        // check for next valid moves in D,L,R,U
        if (row < n - 1 && m[row + 1][col] == 1) {
            path += 'D';
            solve(m, n, row + 1, col, path, paths);
            path = path.substring(0, path.length() - 1);
        }

        if (col > 0 && m[row][col - 1] == 1) {
            path += 'L';
            solve(m, n, row, col - 1, path, paths);
            path = path.substring(0, path.length() - 1);
        }

        if (col < n - 1 && m[row][col + 1] == 1) {
            path += 'R';
            solve(m, n, row, col + 1, path, paths);
            path = path.substring(0, path.length() - 1);
        }

        if (row > 0 && m[row - 1][col] == 1) {
            path += 'U';
            solve(m, n, row - 1, col, path, paths);
            path = path.substring(0, path.length() - 1);
        }

        // mark as unvisited for other paths
        m[row][col] = 1;
    }

}