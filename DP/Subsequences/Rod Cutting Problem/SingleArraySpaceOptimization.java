
class SingleArraySpaceOptimization {
    // Observations
    // 1. Choice (either cut or not cut) -> Recursion -> DP
    // 2. Sub problems can be used to solve the entire problem
    // 3. Maximum of 2 dynamic parameters in the recursive function

    // *** Unbounded Knapsack Pattern ***
    // single array optimization
    public int RodCutting(int price[], int N) {
        int[] curr = new int[N + 1]; // len / N & row1

        for (int i = 0; i < N + 1; i++) {
            curr[i] = i * price[0];
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                int pick = 0;

                if (j >= i) {
                    pick = price[i - 1] + curr[j - i];
                }

                int notpick = curr[j];

                curr[j] = Math.max(pick, notpick);
            }
        }

        return curr[N];
    }
}
