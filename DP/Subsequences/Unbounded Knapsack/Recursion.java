// similar to rod cutting problem
// infinite supply of cuts (here items)

class Recursion {
    public int func(int[] wt, int[] val, int ind, int W) {
        // 0 capacity knapsack
        if(W <= 0) {
            return 0;
        }

        // no items present
        if(ind < 0) {
            return 0;
        }

        // pick item
        int pick = 0;

        if(W >= wt[ind]) {
            pick = val[ind] + func(wt, val, ind, W - wt[ind]);
        }

        // not pick
        int notpick = func(wt, val, ind - 1, W);

        return Math.max(pick, notpick);
    }

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return func(wt, val, n - 1, W);
    }
}
