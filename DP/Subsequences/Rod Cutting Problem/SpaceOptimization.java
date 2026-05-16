// Observations
// 1. Choice (either cut or not cut) -> Recursion -> DP
// 2. Sub problems can be used to solve the entire problem
// 3. Maximum of 2 dynamic parameters in the recursive function

class SpaceOptimization {
    // space optimization approach - since the logic is dependent on only two rows - we can have two arrays and update them on each iteration.

    public int RodCutting(int price[], int N) {
        int[] dp1 = new int[N + 1]; // len / N & row1
        int[] dp2 = new int[N + 1]; // len / N & row2

        dp1[0] = dp2[0] = 0;

        for(int i = 1; i < N + 1; i++) {
            dp1[i] = price[i - 1];
            dp2[i] = -1;
        }

        for(int i = 1; i < N + 1; i++) {
            dp2 = new int[N + 1]; // optional for unbounded knapsack pattern

            for(int j = 1; j < N + 1; j++) {
                if(i > j) {
                    // len < ind
                    dp2[j] = price[j - 1];
                }
                else {
                    int pick = price[i - 1] + dp2[j - i];
                    int notpick = dp1[j];
                    dp2[j] = Math.max(pick, notpick);
                }
            }
            dp1 = dp2;
        }

        return dp2[N];
    }
}