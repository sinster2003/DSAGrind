// Choices: 2 steps or 1 step -> Recursion
// Generate all possible ways
// Boils down to Fibonacci: func(n) = func(n - 1) + func(n - 2)

class Recursion {
    // Recursive approach
    public int climbStairs(int n) {
        if(n == 0) {
            return 1; // valid path
        }

        if(n < 0) {
            return 0; // invalid path
        }

        // 1 step
        int step1 = climbStairs(n - 1);

        // 2 step
        int step2 = climbStairs(n - 2);

        return step1 + step2;
    }
}