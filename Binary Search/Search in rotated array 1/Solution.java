// TIme complexity: O(logn)

class Solution {
    public int search(int[] nums, int k) {
       int low = 0, high = nums.length - 1;

       while(low <= high) {
          int mid = (low + high) / 2;

          if(nums[mid] == k) {
            return mid;
          }
          else if(nums[mid] >= nums[low]) {
            // left half is sorted
            if(k >= nums[low] && k < nums[mid]) {
                high = mid - 1;   
            }
            else {
                low = mid + 1;
            }
          }
          else {
            // right half is sorted
            if(k <= nums[high] && k > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;   
            }
          }
       }

       return -1;
    }
}