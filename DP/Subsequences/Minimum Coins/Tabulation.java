// Choices: pick the coin denomination or do not pick the coin denomination
// Generate all the possible combinations to sum up the target amount and return the most minimum - recursion

class Tabulation {
    // Tabulation approach - bottom up approach
    public int MinimumCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        // fill the base cases
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < amount + 1; i++) {
            dp[0][i] = (i % coins[0]) == 0 ? (i / coins[0]) : Integer.MAX_VALUE; // if first coin divides the amount then total coins else it is invalid
        }

        for(int i = 1; i < coins.length; i++) {
            for(int j = 1; j < amount + 1; j++) {
                int pick = Integer.MAX_VALUE;

                if(j >= coins[i]) {
                    pick = dp[i][j - coins[i]];
                    if(pick != Integer.MAX_VALUE) pick++;
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = Math.min(pick, notpick);
            }
        }

        if(dp[coins.length - 1][amount] == Integer.MAX_VALUE) return -1;

        return dp[coins.length - 1][amount]; 
    }
}