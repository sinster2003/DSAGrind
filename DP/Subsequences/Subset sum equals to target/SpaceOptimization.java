// Choices: Pick or not Pick element to build a subset with the given sum
// Generate all possible ways to find the valid subset -> Recursion 

class Solution {
    // Space optimization approach - double array
    public boolean isSubsetSum(int[] arr, int target) {
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        // base cases
        curr[0] = prev[0] = true;

        for(int i = 1; i < target + 1; i++) {
            prev[i] = (i == arr[0]);
        }

        for(int i = 1; i < arr.length; i++) {
            curr = new boolean[target + 1];
            curr[0] = true;

            for(int j = 1; j < target + 1; j++) {
                boolean pick = false;

                if(j >= arr[i]) {
                    pick = prev[j - arr[i]];
                }

                boolean notpick = prev[j];

                curr[j] = pick || notpick;
            }

            prev = curr;
        }

        return prev[target];
    }
}