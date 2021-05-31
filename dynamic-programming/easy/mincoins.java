import java.util.Arrays;

//Given an amount and an integer array coins
//Find the minimum number of coins needed to make up the amount
//Assume an inifinte supply of each coin
//eg: amount = 11, coins= [1,2,5] 
//minimum coins needed are 3 (5*2 + 1*1);

public class mincoins {
    public static int main(int[] coins, int amount) {
        int max = amount + 1; // max number of coins needed in worst case
        int[] dp = new int[amount + 1];

        // dp[i] stores the minimum number of coins needed to make up amount 'i'
        Arrays.fill(dp, max);

        dp[0] = 0; // 0 coins needed to form $0

        // for amounts in ranges 1 to required amount..
        for (int i = 1; i <= amount; i++) {

            // check minimum number of coins needed to form this amount
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] >= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

                /*
                 * eg: consider amount = 4 and coins[] = {1,2,3}; for i = 1: when j = 0: dp[1] =
                 * min(dp[1], dp[1 - 1] + 1) ==> 1 i.e. 1 coin of 1$ needed to make 1$ amount
                 * for i = 2: when j = 0: dp[2] = min(dp[2], dp[2 - 1] + 1) ==> 2 i.e. 2 coins
                 * of $1 needed to make 2$ when j = 1: dp[2] = min(dp[2], dp[2 - 2] + 1) ==> 1
                 * i.e. 1 coins of $2 needed to make 2$ for i = 3: when j = 0: dp[3] =
                 * min(dp[3], dp[3 - 1] + 1) ==> 2 i.e. 1 coin each of $1 and 2$ needed to make
                 * 3$ when j = 1: dp[3] = min(dp[3], dp[3 - 2] + 1) ==> 2 i.e. 1 coin eahc of $1
                 * and $2 needed to make 3$ when j = 2: dp[3] = min(dp[3], dp[3 - 3] + 1) ==> 1
                 * i.e. 1 coin of 3$ needed to make 3$
                 * 
                 * calculate for i = 4..
                 * 
                 * 
                 * 
                 */

            }

        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
