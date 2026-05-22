class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        if(nums[0] != nums[1]) {
            return nums[0];
        }

        if(nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int low = 1, high = n - 2;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            else if(nums[mid] != nums[mid - 1]) {
                if(mid % 2 == 0) { // the first occurrence needs to be in even index
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                if(mid % 2 == 0) { // the second occurrence needs to be in odd index
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}