// square root of a number lies from 1 to logn
// instead of linear search on answers range
// binary search would give a time complexity O(log(logn))

class Solution {
    public int floorSqrt(int n) {
        int low = 1, high = n;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(n / mid >= mid) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }
}