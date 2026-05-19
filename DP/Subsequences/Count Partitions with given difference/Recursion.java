// Generate all subsets using two choices either pick or not pick
// Generate all possible ways -> Recursion
// total cannot be negative because we are dealing with arraySum and not given sum k. A given sum k can be negative even before traversing all indices but arraySum in the worst case can be 0 when all indices are traversed.

// Core Intuition: Instead of finding two subsets sums and then getting the difference, use the difference and totalSum (arraySum) to determine ONE VALID subset sum. Because if we count one VALID subset sum, automatically remaining sum is subset2 sum which satisfies S1 - S2 = difference.

// Partition two subsets: Think of boiling down the problem to solving for one subset cause automatically and algebraically we determine second subset and given conditions.

// no target == 0 base case because of the existence of 0s' in the array -> we cannot be sure that whether all subsets are covered eg: [0 0 1] and target was 0 -> it would never considers all zeroes.

class Recursion {
    private final int MOD = (int)1e9 + 7;

    public int func(int[] arr, int ind, int target) {
        // when we reach first element
        if(ind == 0) {
            if(arr[ind] == 0 && target == 0) {
                return 2; // this is one exception because elements can be 0 in this problem therefore empty subset and itself leads to 2 count of target 0.
            }
            
            if(target == 0 || arr[ind] == target) {
                return 1; // empty subset or element subset itself
            }

            return 0;
        }

        // pick
        int pick = 0;

        if(target >= arr[ind]) {
            pick = func(arr, ind - 1, target - arr[ind]);
        }

        // notpick
        int notpick = func(arr, ind - 1, target);

        return (pick + notpick) % MOD;
    }

    // Recursive approach
    public int countPartitions(int n, int diff, int[] arr) {
        int arraySum = 0;

        for(int i = 0; i < n; i++) {
            arraySum += arr[i];
        }

        // core idea is to find the count of subsets whose sum is equal to subset1 sum which leads to actual given difference - So determine the subset1's sum so that it satisfies S1 - S2 = diff

        // S1 - S2 = diff & S1 + S2 = arraySum => 2S1 = arraySum + diff

        int S1 = (arraySum + diff) / 2;

        // for S1 - S2 to be equal to diff S1 must be (arraySum + diff) / 2, so count the subsets whose sum is this. thats it

        if(arraySum + diff < 0 || (arraySum + diff) % 2 != 0) {
            // subset sum cannot be negative or in decimal - because count is always 0.
            return 0;
        }

        return func(arr, n - 1, S1);
    }
}