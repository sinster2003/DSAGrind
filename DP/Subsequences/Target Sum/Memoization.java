// Choices: assign + or - -> one way to solve would be recursion
// Better way to solve is to use the concept of subsets
// [1, 2, 7, 1, 5] target = 4 , +1 +2 +7 -1 -5 = 4 Can we say 1, 2, 3 are subset 1 and 1, 5 are subset 2. These are valid subsets. Observe: S1 - S2 = target / diff. The question has been already solved "Partition subsets with given difference".

// [1 + 2 + 7] - [1 + 5] = 4 (target / diff)

// S1 - S2 = diff, S2 = arraySum - S1, solving the eqs: S1 = (arraySum + diff) / 2
// To solve the problem find the subset whose sum is equivalent to the above.

/*
    Mantra when dealing with finding 2 subsets / subsequences problems are boil down the problem to find 1 subset. We always need to find one subset, we get the other from totalSum / arraySum.
*/

import java.util.Arrays;

class Memoization {
    // Memoization approach
    private final int MOD = (int)1e9 + 7;

    public int func(int[] nums, int ind, int target, int[][] dp) {
        // the func finds the count of subsets equal to the target
        if(ind == 0) {
            if(nums[0] == 0 && target == 0) {
                return 2;
            }

            if(target == 0 || nums[0] == target) {
                return 1;
            }

            return 0;
        }

        if(dp[ind][target] != -1) {
            return dp[ind][target];
        }

        // pick
        int pick = 0;
        
        if(target >= nums[ind]) {
           pick = func(nums, ind - 1, target - nums[ind], dp); 
        }

        // notpick
        int notpick = func(nums, ind - 1, target, dp);

        return dp[ind][target] = (pick + notpick) % MOD;
    }

    public int targetSum(int n, int target, int[] nums) {
        // to solve the problem we need to find only the S1 (subset 1 sum)

        int arraySum = 0;

        for(int i = 0; i < n; i++) {
            arraySum += nums[i];
        }

        if((arraySum + target) < 0 || (arraySum + target) % 2 != 0) {
            // if (arraySum + target) is odd or negative -> S1 sum is invalid as subset sum count never be negative or decimals
            return 0;
        }

        int S1 = (arraySum + target) / 2; // (totalSum + diff) / 2

        int[][] dp = new int[n][S1 + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(nums, n - 1, S1, dp);
    }
}