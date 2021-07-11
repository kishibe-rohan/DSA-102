//Question Link: https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1

class Solution {
    int findMinInsertions(String S) {
        // ans = length of string - LCS(s,rev(s));

        int n = S.length();
        StringBuilder sb = new StringBuilder(S);
        sb.reverse();
        String rev = sb.toString();

        return (n - LCS(S, rev, n, n));
    }

    static int LCS(String s1, String s2, int m, int n) {
        // find LCS between string and its reverse

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        return dp[m][n];
    }

}