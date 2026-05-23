class Memoization {
    // Memoization approach
    public int func(int[] heights, int ind, int[] dp) {
        if(ind == 0) {
            return 0;
        }

        if(dp[ind] != -1) {
            return dp[ind];
        }

        // 1 step
        int eff1 = Integer.MAX_VALUE;
        
        if(ind - 1 >= 0) {
            eff1 = func(heights, ind - 1, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        }

        // 2 step
        int eff2 = Integer.MAX_VALUE;
        
        if(ind - 2 >= 0) {
            eff2 = func(heights, ind - 2, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(eff1, eff2);
    }

    public int frogJump(int[] heights) {
        int[] dp = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            dp[i] = -1;
        }

        return func(heights, heights.length - 1, dp);
    }
}