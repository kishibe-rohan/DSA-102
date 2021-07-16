//Find the square root of a given number

class Solution {
    long floorSqrt(long x) {
        // Your code here

        if (x == 0 || x == 1)
            return x;

        // Binary Search in the range 1 to x
        long lo = 1;
        long hi = x;
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            // perfect square? return the ans
            if (mid * mid == x)
                return mid;

            // since it is required to floor the ans
            if (mid * mid <= x) {
                lo = mid + 1;
                ans = mid;
            }

            else
                hi = mid - 1;
        }

        return ans;
    }
}
