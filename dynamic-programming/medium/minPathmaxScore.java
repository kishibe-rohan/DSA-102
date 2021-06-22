//Given a 2D matrix,you start at (0,0) and have to reach cell (r-1,c-1)
//You can move 4-directionally and score alogn a path is the min. element on the path
//Refer Leetcode. 1102

public class minPathmaxScore {
    public static int maxScore2D(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        dp[0][0] = Integer.MAX_VALUE;

        for (int i = 1; i < r; i++)
            dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);

        for (int j = 1; j < c; j++)
            dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (i == r - 1 && j == c - 1)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                else {
                    int s1 = Math.min(grid[i][j], dp[i][j - 1]);
                    int s2 = Math.min(grid[i][j], dp[i - 1][j]);
                    dp[i][j] = Math.max(s1, s2);
                }
            }
        }

        return dp[r - 1][c - 1];

    }
}
