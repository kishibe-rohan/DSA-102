//Given a N*N board representing a snake and ladder game
//Find the minimum moves to reach N*N starting from 1
//for every cell,if it contains -1 => it is a normal cell
//if it contains a positive number,it is a snake/ladder and that number is the cell of its destination

//Approach: Imagine it as a 1-D array and perfrom BFS
//Question Link: https://leetcode.com/problems/snakes-and-ladders/

public class snakesAndLadders {
    private final static int n;

    public int minMoves(int[][] grid) {
        n = grid.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();

        // for starting cell,mark it as visited
        q.offer(1);
        vis[1] = true;
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // number of available moves
            for (int k = 0; k < size; k++) {
                int curr = q.poll();
                // try all moves from this cell
                for (int i = 1; i <= 6; i++) {
                    int next = curr + i;
                    int[] pos = numToPos(next); // 1-D simulation

                    // is a snake or ladder?
                    if (board[pos[0]][pos[1]] > 0)
                        next = board[pos[0]][pos[1]];

                    // reached dest?
                    if (next == n * n)
                        return step;

                    // add to queue
                    if (!vis[next]) {
                        q.offer(next);
                        vis[next] = true;
                    }

                }
            }
            step++;
        }

        return -1;

    }

    private int[] numToPos(int num) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;

        int x = n - 1 - row;
        int y = row % 2 == 0 ? col : n - 1 - col;

        return new int[] { x, y };
    }

}
