// Choices: Pick item or Not Pick item
// Generate all possible combination of items picked within Kanpsack's capacity -> Recursion
// One item can be picked only once (no infinite supply of items)
// We traverse in reverse and fill from the right view of the current array because left view of the array is needed and cannot be manipulated like in unbounded knapsack

class SingleArraySpaceOptimization {
    // Single array space optimization approach
    
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[] curr = new int[W + 1];

        for(int i = 0; i < W + 1; i++) {
            curr[i] = (i >= wt[0]) ? val[0] : 0;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = W; j >= 0; j--) {
                int pick = 0;
                
                if(j >= wt[i]) {
                    pick = val[i] + curr[j - wt[i]];
                }
                
                int notpick = curr[j];
                
                curr[j] = Math.max(pick, notpick);
            }
        }
        
        return curr[W];
    }
}
