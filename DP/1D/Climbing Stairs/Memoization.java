// Choices: 2 steps or 1 step -> Recursion
// Generate all possible ways
// Boils down to Fibonacci: func(n) = func(n - 1) + func(n - 2)

class Memoization {
    // Memoization approach - top down approach
    public int func(int n, int[] dp) {
        if(n == 0) {
            return 1; // valid path
        }

        if(n < 0) {
            return 0; // invalid path
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        // 1 step
        int step1 = func(n - 1, dp);

        // 2 step
        int step2 = func(n - 2, dp);

        return dp[n] = step1 + step2;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

        return func(n, dp);
    }
}