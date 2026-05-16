// Choices: Pick item or Not Pick item
// Generate all possible combination of items picked within Kanpsack's capacity -> Recursion
// One item can be picked only once (no infinite supply of items)

class Recursion {
    // Recursive Solution

    public int func(int[] wt, int[] val, int ind, int W) {
        // if the capacity of Knapsack is 0 or no items present
        if(W <= 0 || ind < 0) {
            return 0;
        }

        // pick the item
        int pick = 0;

        if(W >= wt[ind]) {
            pick = val[ind] + func(wt, val, ind - 1, W - wt[ind]);
        }

        // not pick the item
        int notpick = func(wt, val, ind - 1, W);

        return Math.max(pick, notpick);
    }

    public int knapsack01(int[] wt, int[] val, int n, int W) {
        return func(wt, val, n - 1, W);
    }
}
