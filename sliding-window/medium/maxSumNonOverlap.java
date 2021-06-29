//Question Link: https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
/*
(i-M-L)
 [9,13,2,5,3,6,7,8,9,3,5,7,9]   non-overlap
         (i-M)      (i)
*/

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            preSum[i + 1] = preSum[i] + nums[i];

        return Math.max(maxSum(preSum, L, M), maxSum(preSum, M, L));
    }

    private int maxSum(int[] preSum, int L, int M) {
        int ans = 0;
        int maxL = 0;

        for (int i = L + M; i < preSum.length; i++) {
            maxL = Math.max(maxL, preSum[i - M] - preSum[i - M - L]);
            ans = Math.max(ans, maxL + preSum[i] - preSum[i - M]);
        }

        return ans;
    }
}
