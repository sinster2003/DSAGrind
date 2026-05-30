// Time complexity: O(logn)

class Solution {
    public int lowerBound(int[] nums, int x) {
       // lower bound: smallest index where the number is >= x

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] >= x) {
                high = mid - 1; // left half to search for smaller number
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}