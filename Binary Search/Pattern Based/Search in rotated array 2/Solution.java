// Time complexity: O(logn)

class Solution {
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == k) {
                return true;
            }

            // handling duplicate values where both the halves cannot be discared
            while(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;

                if(low > high) {
                    return false;
                }
            }

            if(nums[mid] >= nums[low]) {
                // left half sorted
                if(k >= nums[low] && k < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                // right half sorted
                if(k <= nums[high] && k > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}