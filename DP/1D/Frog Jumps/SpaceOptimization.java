class SpaceOptimization {
    // SpaceOptimization approach - two variables are needed to track
    public int frogJump(int[] heights) {
        // base case
        int prev1 = 0, prev2 = -1;

        for(int i = 1; i < heights.length; i++) {
            int eff1 = Integer.MAX_VALUE;
        
            if(i - 1 >= 0) {
                eff1 = prev1 + Math.abs(heights[i] - heights[i - 1]);
            }

            int eff2 = Integer.MAX_VALUE;
        
            if(i - 2 >= 0) {
                eff2 = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(eff1, eff2);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}