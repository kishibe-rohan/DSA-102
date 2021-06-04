//Given a string,find the length of its longest repeated subsequence
//Idea: LCS(str,str) where i!=j

public class lrs {
    public int findLRS(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}
