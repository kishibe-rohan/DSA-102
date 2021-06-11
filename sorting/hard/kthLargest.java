//Question Link : https://leetcode.com/problems/kth-largest-element-in-an-array
//Approach: Partial Quicksort (only need last k elements to be sorted)

public class kthLargest {
    public int findKLarge(int[] arr, int k) {
        k = nums.length - k; // only need the last k elements to be sorted
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            final int pivot = partition(arr, lo, hi);
            if (pivot < k)
                lo = pivot + 1;
            else if (pivot > k)
                hi = pivot - 1;
            else
                break;
        }

        return arr[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int pivot = a[hi];
        int pIndex = lo;

        for (int i = lo; i < hi; i++) {
            if (a[i] < pivot) {
                int temp = a[pIndex];
                a[pIndex] = a[i];
                a[i] = temp;
                pIndex++;
            }
        }

        int temp = a[h];
        a[h] = a[pIndex];
        a[pIndex] = temp;

        return pIndex;

    }

}
