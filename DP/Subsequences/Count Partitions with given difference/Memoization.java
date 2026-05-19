import java.util.Arrays;

class Memoization {
    private final int MOD = (int)1e9 + 7;

    // Memoization approach
    public int func(int[] arr, int ind, int target, int[][] dp) {
        // when we reach first element
        if(ind == 0) {
            if(arr[ind] == 0 && target == 0) {
                return 2; // this is one exception because elements can be 0 in this problem therefore empty subset and itself leads to 2 count of target 0.
            }
            
            if(target == 0 || arr[ind] == target) {
                return 1; // empty subset or element subset itself
            }

            return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        // pick
        int pick = 0;

        if(target >= arr[ind]) {
            pick = func(arr, ind - 1, target - arr[ind], dp);
        }

        // notpick
        int notpick = func(arr, ind - 1, target, dp);

        return dp[ind][target] = (pick + notpick) % MOD;
    }

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

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(arr, n - 1, S1, dp);
    }
}
