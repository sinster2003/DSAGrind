class SingleArraySapceOptimization {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        // space optimisation using single array
        int[] curr = new int[W + 1];

        for(int i = 0; i < W + 1; i++) {
            curr[i] = (i / wt[0]) * val[0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < W + 1; j++) {
                int pick = 0;

                if(j >= wt[i]) {
                    pick = val[i] + curr[j - wt[i]];
                }

                int notpick = curr[j];

                curr[j] = Math.max(pick, notpick);
            }
        }

        return curr[W];
    }
}