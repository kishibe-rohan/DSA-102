//Given n items with weights and values
//store them in a Knapsack with max capacity W
//Only 1 quanity of each item
//item cannot be divided into parts (either add it to knapsack or don't)

public class Knapsack {
    public static int main(int[] wt, int[] val, int capacity, int n) {

        // dp[i][j] stores the max value obtained
        // when max capacity is 'j' with first 'i' items
        int[][] dp = new int[n + 1][capacity + 1];

        // for each item
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= capacity; j++) {
                // if max capacity is 0 or we have 0 items to pick
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                // current item can be included
                else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }

                // current item cannot be included as it exceeds capacity
                dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][capacity];
    }

}
