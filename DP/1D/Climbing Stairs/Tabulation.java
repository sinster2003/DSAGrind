// Choices: 2 steps or 1 step -> Recursion
// Generate all possible ways
// Boils down to Fibonacci: func(n) = func(n - 1) + func(n - 2)

class Tabulation {
    // Tabulation approach - bottom up approach
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        
        // base cases: when 0 steps or 1 step is present -> 1 possible way
        dp[0] = dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // f(n) = f(n - 1) + f(n - 2)
        }

        return dp[n];
    }
}