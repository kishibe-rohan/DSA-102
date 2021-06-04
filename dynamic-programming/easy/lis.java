//Given an array of integers,find the longest strictly increasing subsequence

public class lis {
    public int findLIS(int[] arr) {
        int n = arr.length;

        // empty array
        if (n == 0)
            return 0;

        int[] dp = new int[n];

        // array with only 1 element
        dp[0] = 1;
        int ans = 1; // worst case

        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) // forms an increasing subsequence
                    maxVal = Math.max(maxVal, dp[j]);
            }

            dp[i] = 1 + maxVal;
            ans = Math.max(ans, dp[i]);
        }

        return ans;

    }
}
