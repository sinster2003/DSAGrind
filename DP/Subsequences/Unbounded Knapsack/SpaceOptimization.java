// similar to rod cutting problem
// infinite supply of cuts (here items)

class SpaceOptimization {
    // space optimization - since the current and prev row are dependent we can only work with 2 arrays instead of whole matrix

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];

        prev[0] = curr[0] = 0; // W == 0

        for(int i = 1; i < W + 1; i++) {
            prev[i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            curr = new int[W + 1]; // optional for unbounded knapsack pattern

            for(int j = 1; j < W + 1; j++) {
                int pick = 0;

                // ind / i = 3 which i - 1 in wt & val array
                if(j >= wt[i - 1]) {
                    pick = val[i - 1] + curr[j - wt[i - 1]];
                }

                int notpick = prev[j];

                curr[j] = Math.max(pick, notpick);
            }
            prev = curr;
        }

        return curr[W];
    }
}
