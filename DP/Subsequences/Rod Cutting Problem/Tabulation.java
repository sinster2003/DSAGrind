// Observations
// 1. Choice (either cut or not cut) -> Recursion -> DP
// 2. Sub problems can be used to solve the entire problem
// 3. Maximum of 2 dynamic parameters in the recursive function
import java.util.Arrays;

class Tabulation {
    // tabulation approach - bottom up approach

    public int RodCutting(int price[], int N) {
        int[][] dp = new int[N + 1][N + 1]; // ind * N

        for(int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        // fill up the base cases
        for(int i = 0; i < N + 1; i++) {
            dp[i][0] = 0; // len == 0
            if(i > 0) dp[0][i] = price[i - 1]; // ind <= 0
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(i > j) {
                    // len < ind
                    dp[i][j] = price[j - 1];
                }
                else {
                    int pick = price[i - 1] + dp[i][j - i];
                    int notpick = dp[i - 1][j];
                    dp[i][j] = Math.max(pick, notpick);
                }
            }
        }

        return dp[N][N];
    }
}