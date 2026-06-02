class Solution {
    public int maximum(int[] nums) {
        int max = -1;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int minimum(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }

    public int noOfBouquets(int days, int[] nums, int flowers) {
        int count = 0, bouq = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= days) {
                count++;

                if(count == flowers) {
                    bouq++;
                    count = 0;
                }
            }
            else {
                count = 0;
            }
        }

        return bouq;
    }

    public int roseGarden(int n, int[] nums, int k, int m) {
        // edge case
        if(nums.length < (k * m)) {
            return -1; // impossible if number of flowers is less than bouquet flowers
        }

        int low = minimum(nums), high = maximum(nums);

        while(low <= high) {
            int mid = (low + high) / 2;

            int noOfBouq = noOfBouquets(mid, nums, k);

            if(noOfBouq >= m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}