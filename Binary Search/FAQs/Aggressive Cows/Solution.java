// Pattern: Maximize the minimum distance between any 2 elements

import java.util.Arrays;

class Solution {
    public boolean isPossibleToPlaceCows(int[] nums, int distance, int k) {
        int index = 0;
        k--; // place first cow at index 0

        for(int i = 1; i < nums.length; i++) {
            int possibleDistance = nums[i] - nums[index];

            if(possibleDistance >= distance) {
                index = i;
                k--;

                // all cows are placed
                if(k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums); // sorted array ensures minimum distance between cows is always present in the adjacent cows - no need to check for all the cows.

        // Minimum distance between any two case can range from 1 to max of array.

        int n = nums.length;

        int low = 1, high = nums[n - 1]; // range of minimum distance

        while(low <= high) {
            int mid = (low + high) / 2;

            if(isPossibleToPlaceCows(nums, mid, k)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }
}
