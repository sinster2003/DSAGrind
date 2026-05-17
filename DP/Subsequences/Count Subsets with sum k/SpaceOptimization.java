// Constraint: Every number is positive -> no negative numbers
// Choices: Pick or not pick -> recursion
// Generate all possible subsets

class SpaceOptimization {
    // Space Optimization Approach -> double array
    private final int MOD = (int)1e9 + 7;

    public int perfectSum(int[] arr, int K) {
        int[] prev = new int[K + 1];
        int[] curr = new int[K + 1];

        // base cases
        prev[0] = curr[0] = 1;

        for(int i = 1; i < K + 1; i++) {
            prev[i] = (i == arr[0]) ? 1 : 0; // if first element is same target then we found the valid subset
        }

        for(int i = 1; i < arr.length; i++) {
            curr = new int[K + 1];
            curr[0] = 1;

            for(int j = 1; j < K + 1; j++) {
                int pick = 0;

                if(j >= arr[i]) pick = prev[j - arr[i]];

                int notpick = prev[j];

                curr[j] = (pick + notpick) % MOD;
            }

            prev = curr;
        }

        return prev[K];
    }
}