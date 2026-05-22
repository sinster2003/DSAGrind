// Time complexity: O(logn)

class Solution {
    public int first(int[] nums, int target) {
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

        return low == nums.length ? -1: low;
    }

    public int last(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return high;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = first(nums, target);
        int last = last(nums, target);

        int firstOccurrence = (first != -1) && (nums[first] == target) ? first : -1;
        int lastOccurrence = (last != -1) && (nums[last] == target) ? last : -1;

        return new int[]{firstOccurrence, lastOccurrence};
    }
}