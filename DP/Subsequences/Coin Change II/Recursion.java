// Choices: Pick the coin or do not Pick
// Total number of comibnations must be added -> Recursion
// Similar to Unbounded Knapsack

class Recursion {
    // Recursive approach
    private final int MOD = (int)1e9 + 7;

    public int func(int[] coins, int ind, int amount) {
        if(amount == 0) return 1; // valid combination
        if(amount < 0 || ind < 0) return 0; // combination not possible

        // Pick
        int pick = func(coins, ind, amount - coins[ind]);

        // NotPick
        int notPick = func(coins, ind - 1, amount);

        return (pick + notPick) % MOD;
    }

    public int count(int[] coins, int N, int amount) {
        return func(coins, N - 1, amount);
    }
}