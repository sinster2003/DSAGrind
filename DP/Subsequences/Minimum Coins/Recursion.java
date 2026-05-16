// Choices: pick the coin denomination or do not pick the coin denomination
// Generate all the possible combinations to sum up the target amount and return the most minimum - recursion

class Recursion {
    // Recursive approach
    public int miniFunc(int[] coins, int amount, int ind) {
        if(amount == 0) {
            return 0;
        }

        if(ind < 0) {
            return Integer.MAX_VALUE; // not possible to achieve target amount
        }

        // pick the coin
        int pick = Integer.MAX_VALUE;
        
        if(amount >= coins[ind]) {
            pick = miniFunc(coins, amount - coins[ind], ind);
            if(pick != Integer.MAX_VALUE) pick++; // increment pick ie. pick the coin only when sub problem is valid
        }

        // do not pick the coin
        int notpick = miniFunc(coins, amount, ind - 1);

        return Math.min(pick, notpick);
    }

    public int MinimumCoins(int[] coins, int amount) {
        int result = miniFunc(coins, amount, coins.length - 1);
        return (result == Integer.MAX_VALUE) ? -1 : result; 
    }
}

