// Generate all possible subsets - Recursion
// Here and in last problem, subsetSum (total) can never be negative and even if it is 0 no need for the base case because when it becomes, ind would always be < 0. So ind < 0 will handle total or subsetSum == 0. 
// Question might be what total becomes 0 before ind < 0, that can never because here the question deals array's sum and not the given sum k. For array's sum to be zero all elements must be subtracted (so ind < 0 always when total is 0).

class Recursion {
    // Recursive approach
    public int func(int[] arr, int ind, int total, int arraySum) {
        // base case when all elements are traversed
        if(ind < 0) {
            int remainingSum = arraySum - total;
            return Math.abs(total - remainingSum); // subset1 sum - subset2 sum
        }

        // pick
        int pick = func(arr, ind - 1, total - arr[ind], arraySum);

        // notpick
        int notpick = func(arr, ind - 1, total, arraySum);

        return Math.min(pick, notpick);
    }

    public int minDifference(int[] arr, int n) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return func(arr, n - 1, total, total);
    }
}
