// nth root -> find the value of x from the answer range
// where x^n = m => x * x * x represents the cube root
// answer range lies from 1 to M -> binary search

class Solution {
    public int isNthRoot(long mid, int N, int M) {
        long base = mid, ans = 1; // base = 14, N = 10 => (14^2)^5 => 196 ^ 5

        while(N > 0) {
            if(N % 2 == 0) {
                // even
                N = N / 2;
                base *= base;

                if(base > M) {
                    return 2;
                }
            }
            else {
                // odd
                N--;
                ans *= base;

                if(ans > M) {
                    return 2;
                }
            }
        }

        if(ans == M) return 1;
        return 0;
    }
    
    public int NthRoot(int N, int M) {
        long low = 1, high = M;

        while(low <= high) {
            long mid = (low + high) / 2;

            int res = isNthRoot(mid, N, M);

            if(res == 2) {
                // mid is large number
                high = mid - 1;
            }
            else if(res == 1) {
                // mid is the nth root
                return (int) mid;
            }
            else {
                // mid is smaller number
                low = mid + 1;
            }
        }

        return -1;
    }
}
