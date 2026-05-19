class Tabulation {
    private final int MOD = (int)1e9 + 7;

    // Tabulation approach
    public int countPartitions(int n, int diff, int[] arr) {
        int arraySum = 0;

        for(int i = 0; i < n; i++) {
            arraySum += arr[i];
        }

        // core idea is to find the count of subsets whose sum is equal to subset1 sum which leads to actual given difference - So determine the subset1's sum so that it satisfies S1 - S2 = diff

        // S1 - S2 = diff & S1 + S2 = arraySum => 2S1 = arraySum + diff

        int S1 = (arraySum + diff) / 2;

        // for S1 - S2 to be equal to diff S1 must be (arraySum + diff) / 2, so count the subsets whose sum is this. thats it

        if(arraySum + diff < 0 || (arraySum + diff) % 2 != 0) {
            // subset sum cannot be negative or in decimal - because count is always 0.
            return 0;
        }

        int[][] dp = new int[n][S1 + 1];

        // base cases
        for(int i = 0; i < S1 + 1; i++) {
            if(arr[0] == 0 && i == 0) {
                dp[0][i] = 2;
            }
            else if(i == 0 || arr[0] == i) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < S1 + 1; j++) {
                int pick = 0;

                if(j >= arr[i]) {
                    pick = dp[i - 1][j - arr[i]]; // i is 0 based index
                }

                int notpick = dp[i - 1][j];

                dp[i][j] = (pick + notpick) % MOD;
            }
        }

        return dp[n - 1][S1];
    }
}