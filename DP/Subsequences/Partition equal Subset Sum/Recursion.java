// Generate all possible subsets and compare
// To Generate a subset we have 2 choices -> pick and not pick - Recursion
// Note: all integers are positive and total can never be negative because subtracting the total 
// from all elements ultimately leads to 0 and this is only possible because there is no infinite 
// supply of elements.

class Recursion {
    // Recursive approach
    public boolean func(int ind, int total, int[] arr, int sum) {
        if(ind < 0) {
            return (sum - total == total); // sum - half must be half for valid partition
        }

        // pick
        boolean pick = func(ind - 1, total - arr[ind], arr, sum);

        if(pick) return true; // skip right recursion

        // not pick
        boolean notpick = func(ind - 1, total, arr, sum);

        return notpick;
    }

    public boolean equalPartition(int n, int[] arr) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return func(n - 1, total, arr, total); // 4th argument helps us to compare
    }
}