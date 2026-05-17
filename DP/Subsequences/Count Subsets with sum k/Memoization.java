
import java.util.Arrays;

// Constraint: Every number is positive -> no negative numbers
// Choices: Pick or not pick -> recursion
// Generate all possible subsets

class Memoization {
    // Memoization Approach -> prevent overlapping sub problems
    private final int MOD = (int)1e9 + 7;
    
    public int func(int[] arr, int target, int ind, int[][] dp) {
        // if sum becomes 0 -> valid subset
        if(target == 0) {
            return 1;
        }

        // if no elements or if target becomes less than 0 (no negatives - so no subsets possible)
        if(ind < 0 || target < 0) {
            return 0;
        }

        if(dp[ind][target] != -1) {
            return dp[ind][target];
        }

        // Pick
        int pick = func(arr, target - arr[ind], ind - 1, dp);

        // not pick
        int notpick = func(arr, target, ind - 1, dp);

        return dp[ind][target] = (pick + notpick) % MOD;
    }

    public int perfectSum(int[] arr, int K) {
        int[][] dp = new int[arr.length][K + 1];

        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(arr, K, arr.length - 1, dp);
    }
}