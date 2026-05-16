// Choices: pick the coin denomination or do not pick the coin denomination
// Generate all the possible combinations to sum up the target amount and return the most minimum - recursion
import java.util.Arrays;

class Memoization {
    // Memoization approach - top down approach

    public int miniFunc(int[] coins, int amount, int ind, int[][] dp) {
        if(amount == 0) {
            return 0;
        }

        if(ind < 0) {
            return Integer.MAX_VALUE; // not possible to achieve target amount
        }

        if(dp[ind][amount] != -1) {
            return dp[ind][amount];
        }

        // pick the coin
        int pick = Integer.MAX_VALUE;
        
        if(amount >= coins[ind]) {
            pick = miniFunc(coins, amount - coins[ind], ind, dp);
            if(pick != Integer.MAX_VALUE) pick++;
        }

        // do not pick the coin
        int notpick = miniFunc(coins, amount, ind - 1, dp);

        return dp[ind][amount] = Math.min(pick, notpick);
    }

    public int MinimumCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = miniFunc(coins, amount, coins.length - 1, dp);

        return (result == Integer.MAX_VALUE) ? -1 : result; 
    }
}