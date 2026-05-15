// Observations
// 1. Choice (either cut or not cut) -> Recursion -> DP
// 2. Sub problems can be used to solve the entire problem
// 3. Maximum of 2 dynamic parameters in the recursive function

class Recursion {
    public int func(int ind, int len, int[] price) {
        // length of rod is 0
        if(len == 0) {
            return 0;
        }

        // entire rod cannot be cut or ind - 1 leads to negative index
        if(len < ind || ind <= 0) {
            return price[len - 1];
        }

        // cut
        int pick = price[ind - 1];
        pick += func(ind, len - ind, price);

        // not cut
        int notpick = 0;
        notpick += func(ind - 1, len, price);

        return Math.max(pick, notpick);
    }

    public int RodCutting(int price[], int N) {
        return func(N, N, price);
    }
}