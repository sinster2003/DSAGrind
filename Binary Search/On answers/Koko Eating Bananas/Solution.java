// Smallest Divisor pattern

class Solution {
    public int calcHours(int mid, int[] nums) {
        int hrs = 0;

        for(int i = 0; i < nums.length; i++) {
            hrs += Math.ceil((double) nums[i] / mid); // no of hours to eat bananas
        }

        return hrs;
    }

    public int max(int[] nums) {
        int max = -1;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        return max;
    }
    
    public int minimumRateToEatBananas(int[] nums, int h) {
        int low = 1, high = max(nums);

        while(low <= high) {
            int mid = (low + high) / 2;

            int hours = calcHours(mid, nums);

            if(hours <= h) {
                // possible
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}