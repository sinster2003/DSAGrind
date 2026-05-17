
import java.util.Arrays;

// Choices: Pick or not Pick element to build a subset with the given sum
// Generate all possible ways to find the valid subset -> Recursion 

class Memoization {
    // Memoization approach
    public boolean func(int[] arr, int target, int ind, int[][] dp) {
        // valid subset
        if(target == 0) {
            return true;
        }

        // if no elements or target is less than zeo -> invalid subset
        if(ind < 0 || target < 0) {
            return false;
        }

        if(dp[ind][target] != -1) {
            return (dp[ind][target] == 1);
        }
        
        // Pick
        boolean pick = func(arr, target - arr[ind], ind - 1, dp);

        if(pick) {
            dp[ind][target] = 1;
            return true; // skip right recursion in case left recursive result is true
        }

        // Not Pick
        boolean notpick = func(arr, target, ind - 1, dp);

        dp[ind][target] = (notpick == true) ? 1 : 0;
        
        return notpick; // pick || notpick can be used but we know pick is always false here
    }

    public boolean isSubsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];

        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(arr, target, arr.length - 1, dp);
    }
}