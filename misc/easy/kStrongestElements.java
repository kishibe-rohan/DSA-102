//Question Link: https://leetcode.com/problems/the-k-strongest-values-in-an-array/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;

        if (k == n)
            return arr;

        if (k == 0)
            return new int[] {};

        Arrays.sort(arr);
        int median = arr[(n - 1) / 2];

        int l = 0;
        int r = n - 1;

        int[] res = new int[k];
        int i = 0;

        while (l < r) {
            if (Math.abs(arr[l] - median) > Math.abs(arr[r] - median))
                res[i++] = arr[l++];
            else
                res[i++] = arr[r--];

            if (i == k)
                return res;

        }

        return res;
    }
}