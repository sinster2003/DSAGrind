// Choices: Pick the coin or do not Pick
// Total number of comibnations must be added -> Recursion
// Similar to Unbounded Knapsack

class SpaceOptimization {
    private final int MOD = (int)1e9 + 7;

    // Space optimization approach - double array
    public int count(int[] coins, int N, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        prev[0] = curr[0] = 1;

        for(int i = 1; i < amount + 1; i++) {
            prev[i] = (i % coins[0] == 0) ? 1: 0; // if completely divisible -> valid combination
        }

        for(int i = 1; i < N; i++) {
            curr = new int[amount + 1];
            curr[0] = 1; // base case when amount is 0

            for(int j = 1; j < amount + 1; j++) {
                int pick = 0;
                
                // check for negative bounds
                if(j >= coins[i]) {
                    pick = curr[j - coins[i]];
                }

                int notpick = prev[j];

                curr[j] = (pick + notpick) % MOD;
            }

            prev = curr;
        }

        return prev[amount];
    }
}