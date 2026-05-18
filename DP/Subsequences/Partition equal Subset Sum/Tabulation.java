// Generate all possible subsets and compare
// To Generate a subset we have 2 choices -> pick and not pick - Recursion
// Note: all integers are positive and total can never be negative because subtracting the total from all elements ultimately leads to 0 and this is only possible because there is no infinite supply of elements.

class Tabulation {
    // Tabulation approach
    public boolean equalPartition(int n, int[] arr) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][total + 1];

        // when total is 0 not possible to two empty subsets so false.
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = false;
        }

        // when ind < 0, check if the current total obtained is same as the remaining total
        for(int i = 1; i < total + 1; i++) {
            dp[0][i] = (total - i == i); // (sum - total == total)
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < total + 1; j++) {
                boolean pick = false;

                if(j >= arr[i - 1]) {
                    pick = dp[i - 1][j - arr[i - 1]];
                }

                boolean notpick = dp[i - 1][j];
        
                dp[i][j] = pick || notpick;
            }
        }

        return dp[n][total];
    }
}