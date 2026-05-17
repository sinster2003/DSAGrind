// Choices: Pick or not Pick element to build a subset with the given sum
// Generate all possible ways to find the valid subset -> Recursion 

class Tabulation {
    // Tabulation approach - bottom up approach
    public boolean isSubsetSum(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length][target + 1];

        // base cases
        for(int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i < target + 1; i++) {
            dp[0][i] = (i == arr[0]);
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < target + 1; j++) {
                boolean pick = false;

                if(j >= arr[i]) {
                    pick = dp[i - 1][j - arr[i]];
                }

                boolean notpick = dp[i - 1][j];

                dp[i][j] = pick || notpick;
            }
        }

        return dp[arr.length - 1][target];
    }
}