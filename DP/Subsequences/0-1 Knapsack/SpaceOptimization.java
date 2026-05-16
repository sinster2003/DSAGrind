// Choices: Pick item or Not Pick item
// Generate all possible combination of items picked within Kanpsack's capacity -> Recursion
// One item can be picked only once (no infinite supply of items)

class SpaceOptimization {
    // Space optimization approach - since only two rows are needed instead of entire matrix -> create 2 index rows

    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];

        // W <= 0 base case
        prev[0] = curr[0] = 0;

        // ind < 0 base case
        for(int i = 1; i < W + 1; i++) {
            prev[i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            curr = new int[W + 1]; // represents the current item

            for(int j = 1; j < W + 1; j++) {
                int pick = 0;

                // current cap >= current item weight
                if(j >= wt[i - 1]) {
                    pick = val[i - 1] + prev[j - wt[i - 1]]; // observe: the prev array item is picked not the current item like in unbounded knapsack - therefore prev and curr cannot point to the same item or row.
                }

                int notpick = prev[j];

                curr[j] = Math.max(pick, notpick);
            }

            prev = curr;
        }

        return prev[W];
    }
}
