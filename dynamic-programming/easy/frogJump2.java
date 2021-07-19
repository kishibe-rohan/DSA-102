//Question Link : https://atcoder.jp/contests/dp/tasks/dp_b

class Solution {
    public static int main(int[] heights, int n, int k) {
        int[] dp = new int[n];
        if (n == 1)
            return 0;

        dp[0] = 0; // already at stone 1

        // from current stone 'i',a jump can be made in the range (i+1,i+k);
        for (int i = 0; i < n - k; i++) {
            for (int j = i + 1; j <= i + k; j++)
                dp[j] = Math.min(dp[j], dp[i] + (int) Math.abs(heights[j] - heights[i]));
        }

        return dp[n - 1];
    }
}