// Pattern: Book Allocation Problem

// Split Array Sum: Minimizing the maximum subarray sum pattern -> Book Allocation pattern

class Solution {
    public boolean isPossiblePartitions(int[] nums, int maxSum, int k) {
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(totalSum + nums[i] <= maxSum) {
                totalSum += nums[i];
            }
            else {
                k--; // one valid partition is done
                totalSum = 0;
                i--; // points to current i again
            }
        }

        k--; // last valid partition

        // if k < 0 it means we need more partitions than allowed to achieve maxSum as the largest subarray sum

        return (k < 0) ? false : true; // !(k < 0)
    }

    public int maximum(int[] nums) {
        int max = -1;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int total(int[] nums) {
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        return total;
    }
    
    public int largestSubarraySumMinimized(int[] nums, int k) {
        int low = maximum(nums), high = total(nums);

        while(low <= high) {
            int mid = (low + high) / 2;

            if(isPossiblePartitions(nums, mid, k)) {
                high = mid - 1; 
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}
