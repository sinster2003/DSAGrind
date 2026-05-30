class Solution2 {
    public int firstOccurrence(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1, result = n;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                result = Math.min(result, mid);
                high = mid - 1;
            }
            else if(nums[mid] >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result == n ? -1 : result;
    }

    public int lastOccurrence(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1, result = -1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                result = Math.max(result, mid);
                low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{
            firstOccurrence(nums, target),
            lastOccurrence(nums, target)
        };

        return result;
    }
}