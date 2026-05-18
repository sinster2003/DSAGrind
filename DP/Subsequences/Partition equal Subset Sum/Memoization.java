// Generate all possible subsets and compare
// To Generate a subset we have 2 choices -> pick and not pick - Recursion
// Note: all integers are positive and total can never be negative because subtracting the total from all elements ultimately leads to 0 
// and this is only possible because there is no infinite supply of elements.

import java.util.Arrays;

class Memoization {
    // Memoization approach
    public boolean func(int ind, int total, int[] arr, int sum, int[][] dp) {
        // when elements are traversed completely
        if(ind < 0) {
            return (sum - total == total); // sum - half must be half for valid partition
        }

        // memoized result
        if(dp[ind][total] != -1) {
            return (dp[ind][total] == 1);
        }

        // pick
        boolean pick = func(ind - 1, total - arr[ind], arr, sum, dp);

        if(pick) {
            dp[ind][total] = 1; // skip right recursion
            return true;
        }

        // not pick
        boolean notpick = func(ind - 1, total, arr, sum, dp);

        dp[ind][total] = notpick ? 1 : 0;

        return notpick;
    }

    public boolean equalPartition(int n, int[] arr) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int[][] dp = new int[n][total + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(n - 1, total, arr, total, dp); // 4th argument helps us to compare
    }
}