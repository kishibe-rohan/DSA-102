//Given an amount and array of coins
//return the number of ways to make up the amount using the given coins
//assume unlimited supply of coins
//Idea: Knapsack Problem
//(No. of ways to make up amount without using this coin + using this coin) 

public class coinchange {
    public static int main(int[] coins, int amount) {
        // dp[i] stores the number of ways to form amount i
        int[] dp = new int[amount + 1];

        dp[0] = 1; // can always form amount 0

        // for current coin
        for (int coin : coins) {
            // check for all amounts >= this coin's value and add it to the combination
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        /*
         * eg: amount = 5 coins[] = {1,2,5}
         * 
         * dp[0] = 1;
         * 
         * for coin = 1: for j = 1: dp[1] = dp[1] + dp[1-1] => 1 for j = 2: dp[2] =
         * dp[2] + dp[2-1] => 1.. dp[3] to dp[5] also end up being 1 indicating there is
         * only 1 way to form those amounts with 1$ i.e. by adding 1$ coins
         * 
         * for coin = 2: for j = 2: dp[2] = dp[2] + dp[0] => 1 + 1 => 2 i.e. 2 can be
         * formed by either 2 coins of 1$ or 1 coin of 2$ Similarly continue..
         * 
         */

        return dp[amount];
    }

}
