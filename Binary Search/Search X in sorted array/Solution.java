// time complexity: O(N) -> O(logN)
// Note: array needs to sorted for binary search to work

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // when low > high: entire array is traversed
        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                return mid; // index to be returned
            }
            else if(nums[mid] < target) {
                low = mid + 1; // if mid is less than target -> target lies in the right half
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}