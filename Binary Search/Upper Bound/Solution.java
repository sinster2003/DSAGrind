// Time complexity: O(logn)

class Solution {
    public int upperBound(int[] nums, int x) {
        // upper bound: smallest index where number > x
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}