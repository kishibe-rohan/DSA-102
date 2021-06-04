//Given two strings s1 and s2,find the length of their longest common subsequence 
//Recurrence: if(s1[i] == s2[j]) => 1 + LCS(s1[i-1],s2[j-1])
//else if(s1[i] != s2[j]) => max(LCS(s1[i-1],s2[j]),LCS(s1[i],s2[j-1]))
public class lcs {
    public static int findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // first row and col are zero i.e. 0 LCS for empty string
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
