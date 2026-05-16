// Choices: pick the coin denomination or do not pick the coin denomination
// Generate all the possible combinations to sum up the target amount and return the most minimum - recursion

class SpaceOptimization {
    // Space optimization
    public int MinimumCoins(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        prev[0] = curr[0] = 0;

        for(int i = 1; i < amount + 1; i++) {
            prev[i] = (i % coins[0]) == 0 ? (i / coins[0]) : Integer.MAX_VALUE; // if first coin divides the amount then total coins else it is invalid
        }

        for(int i = 1; i < coins.length; i++) {
            curr = new int[amount + 1];

            for(int j = 1; j < amount + 1; j++) {
                int pick = Integer.MAX_VALUE;

                if(j >= coins[i]) {
                    pick = curr[j - coins[i]];
                    if(pick != Integer.MAX_VALUE) pick++;
                }

                int notpick = prev[j];

                curr[j] = Math.min(pick, notpick);
            }

            prev = curr;
        }

        if(prev[amount] == Integer.MAX_VALUE) return -1;

        return prev[amount]; 
    }
}