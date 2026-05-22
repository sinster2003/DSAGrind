class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int ceil = -1, floor = -1;

        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == x) {
                return new int[]{nums[mid], nums[mid]};
            }
            else if(nums[mid] > x) {
                ceil = (ceil == -1) ? nums[mid] : Math.min(ceil, nums[mid]);

                high = mid - 1;
            }
            else {
                floor = Math.max(floor, nums[mid]);
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }
}