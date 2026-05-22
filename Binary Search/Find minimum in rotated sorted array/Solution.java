// time complexity: O(logn)

import java.util.ArrayList;

class Solution {
    public int findMin(ArrayList<Integer> nums) {
      int low = 0, high = nums.size() - 1, result = Integer.MAX_VALUE;

      while(low <= high) {
        int mid = (low + high) / 2;

        if(nums.get(mid) >= nums.get(low)) {
            // left half sorted
            result = Math.min(result, nums.get(low));
            low = mid + 1;
        }
        else {
            // right half sorted
            result = Math.min(result, nums.get(mid));
            high = mid - 1;
        }
      }

      return result;
    }
}