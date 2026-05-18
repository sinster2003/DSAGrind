// Generate all possible subsets - Recursion
// Here and in last problem, subsetSum (total) can never be negative and even if it is 0 no need for the base case because when it becomes, ind would always be < 0. So ind < 0 will handle total or subsetSum == 0. 
// Question might be what total becomes 0 before ind < 0, that can never because here the question deals array's sum and not the given sum k. For array's sum to be zero all elements must be subtracted (so ind < 0 always when total is 0).

class SpaceOptimization {
    // Space Optimization approach - bottom up approach
    public int minDifference(int[] arr, int n) {
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int[] prev = new int[total + 1];
        int[] curr = new int[total + 1];

        // base cases
        prev[0] = curr[0] = Integer.MAX_VALUE;
    
        for(int i = 1; i < total + 1; i++) {
            prev[i] = Math.abs((2 * i) - total); // i - total - i ie. (total - arraySum = remainingSum) - total
        }

        for(int i = 1; i < n + 1; i++) {
            curr = new int[total + 1];
            curr[0] = Integer.MAX_VALUE;

            for(int j = 1; j < total + 1; j++) {
                int pick = Integer.MAX_VALUE;

                if(j >= arr[i - 1]) {
                    pick = prev[j - arr[i - 1]];
                }

                int notpick = prev[j];

                curr[j] = Math.min(pick, notpick);
            }    

            prev = curr;  
        }

        return (prev[total] == Integer.MAX_VALUE) ? 0 : prev[total];
    }
}