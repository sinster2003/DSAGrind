// Pattern: Minimize the maximum subarray sum

class Solution {
    public boolean isPossibleToDistribute(int[] nums, int maxPages, int k) {
        int totalPages = 0;

        for(int i = 0; i < nums.length; i++) {
            if(totalPages + nums[i] <= maxPages) {
                totalPages += nums[i];
            }
            else {
                k--; // assigned totalPages to one student

                // Note: do not return k == 0 from here because we have not distributed every book yet.

                totalPages = 0;
                i--; // do not skip current book as it is not considered
            }
        }

        k--; // last student who keeps getting notes till the end -neve falls into else condition

        // if we need more students than permitted to distribute all pages not possible.
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

    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // impossible case - no of students greater than number of books
        if(m > n) {
            return -1;
        }

        int low = maximum(nums), high = total(nums);

        while(low <= high){
            int mid = (low + high) / 2;

            if(isPossibleToDistribute(nums, mid, m)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}