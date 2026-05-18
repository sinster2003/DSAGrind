// Generate all possible subsets and compare
// To Generate a subset we have 2 choices -> pick and not pick - Recursion
// Note: all integers are positive and total can never be negative because subtracting the total from all elements ultimately leads to 0 and this is only possible because there is no infinite supply of elements.

class SpaceOptimization {
    // Space Optimization approach
    public boolean equalPartition(int n, int[] arr) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        boolean[] prev = new boolean[total + 1];
        boolean[] curr = new boolean[total + 1];

        // when total is 0 not possible to two empty subsets so false.
        prev[0] = curr[0] = false;

        // when ind < 0, check if the current total obtained is same as the remaining total
        for(int i = 1; i < total + 1; i++) {
            prev[i] = (total - i == i); // (sum - total == total)
        }

        for(int i = 1; i < n + 1; i++) {
            curr = new boolean[total + 1];

            for(int j = 1; j < total + 1; j++) {
                boolean pick = false;

                if(j >= arr[i - 1]) {
                    pick = prev[j - arr[i - 1]];
                }

                boolean notpick = prev[j];
        
                curr[j] = pick || notpick;
            }

            prev = curr;
        }

        return prev[total];
    }
}