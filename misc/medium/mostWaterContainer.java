//Question Link: https://leetcode.com/problems/container-with-most-water/
//area = w*h => w = j-i and height is restricted by min(height[i],height[j]);
//use two pointers and move in from the shorter height side

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxArea;
    }
}