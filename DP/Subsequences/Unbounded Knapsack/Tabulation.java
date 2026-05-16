// similar to rod cutting problem
// infinite supply of cuts (here items)
import java.util.Arrays;

class Tabulation {
    // tabulation - bottom up approach

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                int pick = 0;

                // ind / i = 3 which i - 1 in wt & val array
                if(j >= wt[i - 1]) {
                    pick = val[i - 1] + dp[i][j - wt[i - 1]];
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notpick);
            }
        }

        return dp[n][W];
    }
}
