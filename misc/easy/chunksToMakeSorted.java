//Question Link: https://leetcode.com/problems/max-chunks-to-make-sorted

class Solution {
    public int maxChunksToSorted(int[] arr) {
        // if the element at current index is maxElement,all elements before it must be
        // smaller than it
        // so this forms an unsorted seuqence of elements [0...max]

        int n = arr.length;
        if (arr == null || n == 0)
            return 0;

        int count = 0, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                count++;
        }

        return count;
    }
}
