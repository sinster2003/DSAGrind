// Choices: Pick the coin or do not Pick
// Total number of comibnations must be added -> Recursion
// Similar to Unbounded Knapsack
import java.util.Arrays;

class Memoization {
    private final int MOD = (int)1e9 + 7;

    // Memoization approach - memoize the overlapping subproblem
    public int func(int[] coins, int ind, int amount, int[][] dp) {
        if(amount == 0) return 1; // valid combination
        if(amount < 0 || ind < 0) return 0; // combination not possible

        if(dp[ind][amount] != -1) {
            return dp[ind][amount];
        }

        // Pick
        int pick = func(coins, ind, amount - coins[ind], dp);

        // NotPick
        int notPick = func(coins, ind - 1, amount, dp);

        return dp[ind][amount] = (pick + notPick) % MOD;
    }

    public int count(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];

        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(coins, N - 1, amount, dp);
    }
}
