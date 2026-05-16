// similar to rod cutting problem
// infinite supply of cuts (here items)
import java.util.Arrays;

class Memoization {
    // memoization - top down approach - memoize the result of overlapping sub problems

    public int func(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // 0 capacity knapsack
        if(W <= 0) {
            return 0;
        }

        // no items present
        if(ind < 0) {
            return 0;
        }

        if(dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // pick item
        int pick = 0;

        // add price only if item picked
        if(W >= wt[ind]) {
            pick = val[ind] + func(wt, val, ind, W - wt[ind], dp);
        }

        // not pick
        int notpick = func(wt, val, ind - 1, W, dp);

        return dp[ind][W] = Math.max(pick, notpick);
    }

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(wt, val, n - 1, W, dp);
    }
}
