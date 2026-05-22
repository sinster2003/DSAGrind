// Problem boils down to find the minimum number in the array
// The most minimum number index is the number of times the array is rotated.
// Time complexity: O(logn)

import java.util.ArrayList;

class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1, result = Integer.MAX_VALUE, rotations = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums.get(mid) >= nums.get(low)) {
                // left half is sorted
                if(nums.get(low) < result) {
                    result = nums.get(low);
                    rotations = low;
                }

                low = mid + 1;
            }
            else {
                // right half is sorted
                if(nums.get(mid) < result) {
                    result = nums.get(mid);
                    rotations = mid;
                }

                high = mid - 1;
            }
        }

        return rotations;
    }
}