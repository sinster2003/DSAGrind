// Choices: one jump or two jumps -> Recursion to generate all possible ways

class Recursion {
    // Recursive approach
    public int func(int[] heights, int ind) {
        if(ind == 0) {
            return 0;
        }

        // 1 step
        int eff1 = Integer.MAX_VALUE;
        
        if(ind - 1 >= 0) {
            eff1 = func(heights, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);
        }

        // 2 step
        int eff2 = Integer.MAX_VALUE;
        
        if(ind - 2 >= 0) {
            eff2 = func(heights, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return Math.min(eff1, eff2);
    }

    public int frogJump(int[] heights) {
        return func(heights, heights.length - 1);
    }
}