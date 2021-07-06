//Question Link: https://www.geeksforgeeks.org/maximum-time-required-for-all-patients-to-get-infected/

class Solution {
    static class Cell {
        int row, col, time;

        Cell(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }

    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int helpaterp(int[][] hospital) {
        // code here
        int m = hospital.length;
        int n = hospital[0].length;

        int time = 0;
        int uninfected = 0;

        boolean[][] visited = new boolean[m][n];

        Queue<Cell> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hospital[i][j] == 2) {
                    q.add(new Cell(i, j, 0));
                    visited[i][j] = true;
                } else if (hospital[i][j] == 1)
                    uninfected++;

            }
        }

        while (!q.isEmpty()) {
            Cell curr = q.poll();
            time = curr.time;

            for (int[] d : dirs) {
                int i = curr.row + d[0];
                int j = curr.col + d[1];

                if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || hospital[i][j] != 1)
                    continue;

                q.add(new Cell(i, j, time + 1));
                visited[i][j] = true;
                uninfected--;
            }

        }

        if (uninfected != 0)
            return -1;

        return time;

    }
}
