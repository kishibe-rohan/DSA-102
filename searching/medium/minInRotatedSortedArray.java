//Question Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) // right side not sorted,mi must be in [mid,hi]
                lo = mid + 1;
            else if (nums[mid] < nums[lo]) // left side not sorted,mi must be in [lo,mid];
            {
                hi = mid;
                lo++;
            } else
                hi--; // nums[lo] <= nums[mid] <= nums[hi];

        }

        return nums[lo];
    }
}
