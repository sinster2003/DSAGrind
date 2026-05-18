// Generate all possible subsets - Recursion
// Here and in last problem, subsetSum (total) can never be negative and even if it is 0 no need for the base case because when it becomes, ind would always be < 0. So ind < 0 will handle total or subsetSum == 0. 
// Question might be what total becomes 0 before ind < 0, that can never because here the question deals array's sum and not the given sum k. For array's sum to be zero all elements must be subtracted (so ind < 0 always when total is 0).

class Tabulation {
    // Tabulation approach - bottom up approach
    public int minDifference(int[] arr, int n) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int[][] dp = new int[n + 1][total + 1];

        // base cases
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
    
        for(int i = 1; i < total + 1; i++) {
            dp[0][i] = Math.abs((2 * i) - total); // i - total - i ie. (total - arraySum = remainingSum) - total
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < total + 1; j++) {
                int pick = Integer.MAX_VALUE;

                if(j >= arr[i - 1]) {
                    pick = dp[i - 1][j - arr[i - 1]];
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = Math.min(pick, notpick);
            }      
        }

        return (dp[n][total] == Integer.MAX_VALUE) ? 0 : dp[n][total];
    }
}