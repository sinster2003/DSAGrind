class Solution {
    public int division(int mid, int[] nums) {
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += Math.ceil((double) nums[i] / mid);    
        }

        return total;
    }

    public int maximum(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int smallestDivisor(int[] nums, int limit) {
       int low = 1, high = maximum(nums);

       while(low <= high) {
          int mid = (low + high) / 2;
          
          int total = division(mid, nums);

          if(total <= limit) {
            high = mid - 1;
          }
          else {
            low = mid + 1;
          }
       }

       return low;
    }
}