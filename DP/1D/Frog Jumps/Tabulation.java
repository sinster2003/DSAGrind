class Tabulation {
    // Tabulation approach - bottom up
    public int frogJump(int[] heights) {
        int[] dp = new int[heights.length];

        // base case
        dp[0] = 0;

        for(int i = 1; i < heights.length; i++) {
            int eff1 = Integer.MAX_VALUE;
        
            if(i - 1 >= 0) {
                eff1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            }

            int eff2 = Integer.MAX_VALUE;
        
            if(i - 2 >= 0) {
                eff2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(eff1, eff2);
        }

        return dp[heights.length - 1];
    }
}