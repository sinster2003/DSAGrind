// Constraint: Every number is positive -> no negative numbers
// Choices: Pick or not pick -> recursion
// Generate all possible subsets

class Tabulation {
    // Tabulation Approach -> bottom up approach
    private final int MOD = (int)1e9 + 7;

    public int perfectSum(int[] arr, int K) {
        int[][] dp = new int[arr.length][K + 1];

        // base cases
        for(int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < K + 1; i++) {
            dp[0][i] = (i == arr[0]) ? 1 : 0; // if first element is same target then we found the valid subset
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < K + 1; j++) {
                int pick = 0;

                if(j >= arr[i]) pick = dp[i - 1][j - arr[i]];

                int notpick = dp[i - 1][j];

                dp[i][j] = (pick + notpick) % MOD;
            }
        }

        return dp[arr.length - 1][K];
    }
}