// Choices: Pick item or Not Pick item
// Generate all possible combination of items picked within Kanpsack's capacity -> Recursion
// One item can be picked only once (no infinite supply of items)

class Tabulation {
    // Tabulation approach - bottom up approach
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // fill the base cases when W <= 0 and ind < 0
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                int pick = 0;

                // current cap >= current item weight
                if(j >= wt[i - 1]) {
                    pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notpick);
            }
        }

        return dp[n][W];
    }
}
