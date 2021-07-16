//Question Link: https://practice.geeksforgeeks.org/problems/find-the-highest-number2259/1

class Solution {
    public int findPeakElement(List<Integer> a) {
        // Code here
        int n = a.size();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = a.get(i);

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // falling slope? go left
            if (arr[mid] > arr[mid + 1])
                hi = mid;
            // rising slope?go right
            else
                lo = mid + 1;
        }

        return arr[lo];
    }

}