//Question Link: https://atcoder.jp/contests/dp/tasks/dp_a

class Solution {
    public static int main(int[] heights, int n) {
        int[] dp = new int[n];
        if (n == 1)
            return 0;

        dp[0] = 0; // already at stone 1
        dp[1] = (int) Math.abs(heights[1] - heights[0]); // stone 2 can only be reached from stone 1

        // a stone can be reached either from its previous stone or the stone 2 stones
        // behind
        for (int i = 2; i < n; i++)
            dp[i] = Math.min(dp[i - 1] + (int) Math.abs(heights[i] - heights[i - 1]),
                    dp[i - 2] + (int) Math.abs(heights[i] - heights[i - 2]));

        return dp[n - 1];
    }
}