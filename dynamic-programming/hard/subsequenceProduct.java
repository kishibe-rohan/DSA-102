//Given an array of positive integers,find the number of subsequences 
//with product strictly less than K

public class subsequenceProduct {
    public int findSubseq(int[] arr, int K) {
        int n = arr.length;

        // dp[i][j] stores the number of subsequences using first 'j-1' elements
        // with product less than k-1
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1]; // number of subsequences without includign current element

                // include only if the number is less than K
                if (arr[j - 1] <= k)
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
            }
        }

        return dp[k][n];
    }
}
