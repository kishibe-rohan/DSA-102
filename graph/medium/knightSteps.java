import java.util.Queue;

/*
On a NxN chessboard,
given starting position of knight and a target position.
Find the minimum steps needed for knight to reach target pos.
(1-based indexing)
*/

public class knightSteps {
    private static final int[][] DIRS = new int[][] { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 },
            { 1, -2 }, { 2, -1 } };

    public static int main(int[] start, int[] target, int N) {

        int steps = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        Set<int[]> visited = new HashSet<>();
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // get current position
                int[] curr = q.remove();
                int currX = curr[0];
                int currY = curr[1];

                // reached target
                if (currX == target[0] && currY == target[1])
                    return steps;

                // check all possible moves from this position
                for (int[] dir : DIRS) {
                    int nextX = currX + dir[0];
                    int nextY = currY + dir[1];
                    int next[] = new int[] { nextX, nextY };

                    if (!visited.contains(next) && nextX >= 1 && nextY >= 1 && nextX <= N && nextY <= N) {
                        q.add(next);
                        visited.add(next);
                    }

                }

                steps++;
            }
        }

        return -1;
    }
}
