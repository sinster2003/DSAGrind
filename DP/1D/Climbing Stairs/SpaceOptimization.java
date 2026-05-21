// Choices: 2 steps or 1 step -> Recursion
// Generate all possible ways
// Boils down to Fibonacci: func(n) = func(n - 1) + func(n - 2)

class Solution {
    // SpaceOptimization approach
    public int climbStairs(int n) {
        int prev1, prev2;

        // base cases: when 0 steps or 1 step is present -> 1 possible way
        prev2 = prev1 = 1; // dp[0] = dp[1] = 1

        for(int i = 2; i < n + 1; i++) {
            int curr = prev1 + prev2; // f(n) = f(n - 1) + f(n - 2)
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}