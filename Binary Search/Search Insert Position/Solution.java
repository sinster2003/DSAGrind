// Time complexity: O(logn)

class Solution {
    public int searchInsert(int[] nums, int target) {
        // similar to lower bound - smallest index where number >= target

        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}