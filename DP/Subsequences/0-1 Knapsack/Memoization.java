// Choices: Pick item or Not Pick item
// Generate all possible combination of items picked within Kanpsack's capacity -> Recursion
// One item can be picked only once (no infinite supply of items)
import java.util.Arrays;

class Memoization {
    // Memoization approach - memoize the overlapping subproblems

    public int func(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // if the capacity of Kanpsack is 0 or no items present
        if(W <= 0 || ind < 0) {
            return 0;
        }

        // memoized result
        if(dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // pick the item
        int pick = 0;

        if(W >= wt[ind]) {
            pick = val[ind] + func(wt, val, ind - 1, W - wt[ind], dp);
        }

        // not pick the item
        int notpick = func(wt, val, ind - 1, W, dp);

        return dp[ind][W] = Math.max(pick, notpick); // memoize
    }

    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(wt, val, n - 1, W, dp);
    }
}
