// Constraint: Every number is positive - no negative numbers
// Choices: Pick or not pick -> recursion
// Generate all possible subsets

class Recursion {
    // Recursive Approach
    private final int MOD = (int)1e9 + 7;
    
    public int func(int[] arr, int target, int ind) {
        // if sum becomes 0 -> valid subset
        if(target == 0) {
            return 1;
        }

        // if no elements or if target becomes less than 0 (no negatives - so no subsets possible)
        if(ind < 0 || target < 0) {
            return 0;
        }

        // Pick
        int pick = func(arr, target - arr[ind], ind - 1);

        // not pick
        int notpick = func(arr, target, ind - 1);

        return (pick + notpick) % MOD;
    }

    public int perfectSum(int[] arr, int K) {
        return func(arr, K, arr.length - 1);
    }
}