// Choices: Pick or not Pick element to build a subset with the given sum
// Generate all possible ways to find the valid subset -> Recursion 

class Recursion {
    // Recursive approach
    public boolean func(int[] arr, int target, int ind) {
        // valid subset
        if(target == 0) {
            return true;
        }

        // if no elements or target is less than zeo -> invalid subset
        if(ind < 0 || target < 0) {
            return false;
        }
        
        // Pick
        boolean pick = func(arr, target - arr[ind], ind - 1);

        if(pick) {
            return true; // skip right recursion in case left recursive result is true
        }

        // Not Pick
        boolean notpick = func(arr, target, ind - 1);

        return notpick; // pick || notpick can be used but we know pick is always false here
    }

    public boolean isSubsetSum(int[] arr, int target) {
        return func(arr, target, arr.length - 1);
    }
}