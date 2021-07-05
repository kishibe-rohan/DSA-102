//Question Link: https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        // area of water trapped depends on the min(maxL,maxR)
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;
        int ans = 0;

        while (l < r) {
            if (height[l] > lMax)
                lMax = height[l];
            if (height[r] > rMax)
                rMax = height[r];

            if (lMax < rMax) {
                ans += lMax - height[l];
                l++;
            } else {
                ans += rMax - height[r];
                r--;
            }
        }

        return ans;
    }
}