//Question Link : https://atcoder.jp/contests/dp/tasks/dp_c

class Solution {
    public static int main(int[] a, int[] b, int[] c, int n) {
        if (n == 1)
            return Math.max(Math.max(a, b), Math.max(b, c));

        // dp[i] refers to the gain if activity picked was i;
        int[] dp = new int[3];

        // if there was only 1 day
        dp[0] = a[0];
        dp[1] = b[0];
        dp[2] = c[0];

        for (int i = 1; i < n; i++) {
            int ha = a[i];
            int hb = b[i];
            int hc = c[i];

            // if activity 'a' is picked today,it means yesterday either activity 'b' or 'c'
            // was picked
            dp[0] = ha + Math.max(dp[1], dp[2]);
            dp[1] = hb + Math.max(dp[0], dp[2]);
            dp[2] = hc + Math.max(dp[0], dp[1]);
        }

        return Math.max(Math.max(dp[0], dp[1]), Math.max(dp[1], dp[2]));
    }
}