// Observations
// 1. Choice (either cut or not cut) -> Recursion -> DP
// 2. Sub problems can be used to solve the entire problem
// 3. Maximum of 2 dynamic parameters in the recursive function
import java.util.Arrays;

class Memoization {
    // memoization approach - memoize result of the overlapping subproblem

    public int func(int ind, int len, int[] price, int[][] dp) {
        // length of rod is 0
        if(len == 0) {
            return 0;
        }

        // entire rod cannot be cut or ind - 1 leads to negative index
        if(len < ind || ind <= 0) {
            return price[len - 1];
        }

        if(dp[ind][len] != -1) {
            return dp[ind][len];
        }

        // cut
        int pick = price[ind - 1];
        pick += func(ind, len - ind, price, dp);

        // not cut
        int notpick = 0;
        notpick += func(ind - 1, len, price, dp);

        return dp[ind][len] = Math.max(pick, notpick);
    }

    public int RodCutting(int price[], int N) {
        int[][] dp = new int[N + 1][N + 1]; // ind * N

        for(int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(N, N, price, dp);
    }
}