//Question Link: https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535
//Idea: Partition array into k subarrays such that the maxSum among them is minimum
//Binary search in the range (max_element,sum);

class Solution {
    static long minTime(int[] arr, int n, int k) {
        // code here
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int a : arr) {
            max = Math.max(max, (long) a);
            sum += (long) a;
        }

        long l = max;

        long r = sum;

        while (l < r) {
            long mid = l + (r - l) / 2;
            if (required(mid, arr, n, k) <= k)
                r = mid;
            else
                l = mid + 1;

        }

        return l;
    }

    static int required(long target, int[] arr, int n, int k) {
        int painters = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i];
            if (sum > target) {
                sum = arr[i];
                painters++;
            }
        }

        return painters;
    }
}
