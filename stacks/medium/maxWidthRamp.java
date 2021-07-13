//Question Link: https://leetcode.com/problems/maximum-width-ramp

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>(); // possible candidates for start of ramp
        int n = nums.length;

        for (int i = 0; i < n; i++)
            if (st.isEmpty() || nums[st.peek()] > nums[i]) // add only smaller elements
                st.push(i);

        // ramp end candidates
        int ans = 0;
        for (int i = n - 1; i > ans; i--)
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                ans = Math.max(ans, i - st.pop());

        return ans;

    }
}
