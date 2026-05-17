// Choices: Pick the coin or do not Pick
// Total number of comibnations must be added -> Recursion
// Similar to Unbounded Knapsack

class Tabulation {
    private final int MOD = (int)1e9 + 7;

    // Tabulation approach - bottom up approach
    public int count(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];

        // filling up base cases
        for(int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < amount + 1; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1: 0; // if completely divisible -> valid combination
        }

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < amount + 1; j++) {
                int pick = 0;
                
                // check for negative bounds
                if(j >= coins[i]) {
                    pick = dp[i][j - coins[i]];
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = (pick + notpick) % MOD;
            }
        }

        return dp[N - 1][amount];
    }
}
