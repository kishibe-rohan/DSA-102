//Given a MxN matrix consisting of positive integers
//A person starts on any row of the first column and travels to the last column(any row)
//The person can only move right(i,j+1) or diagonally right up(i-1,j+1) or diagonally right down(i+1,j+1)
//Find the max amount of gold he can collect on his path to last column

public class goldMine {
    public static int maxGold(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // dp[i][j] stores the max amount of gold collected on reaching cell(i-1,j-1)
        int[][] dp = new int[m + 1][n + 1];

        // mark row 1 and column 1 of dp array as 0s
        for (int i = 0; i <= m; i++)
            dp[m][0] = 0;

        for (int j = 0; j <= n; j++)
            dp[0][n] = 0;

        // 1st col remains the same
        for (int i = 1; i <= m; i++)
            dp[m][1] = dp[m - 1][0];

        // for remaining columns
        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                // either travelled right to reach here or right up or right down
                int right = dp[i][j - 1];
                int right_up = dp[i + 1][j - 1];
                int right_down = dp[i - 1][j - 1];

                int max = Math.max(Math.max(right_down, right_up), right);
                dp[i][j] = max + mat[i - 1][j - 1];
            }
        }

        // find the max value in last column
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++)
            result = Math.max(result, dp[i][n]);

        return result;
    }
}
