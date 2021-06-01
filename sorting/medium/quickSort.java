//Given an array of integers,peform quicksort on it
//pivot -> divides the array into left and right subarrays
//left subarray elements are smaller than pivot and right are greater
//O(nlogn)

public class quickSort {
    public static void main(String[] args) {
        int[] a = { 2, 7, 1, 6, 4, 8 };
        int n = a.length;
        quicksort(a, 0, n - 1);
    }

    private static void quicksort(int[] a, int l, int h) {
        if (l >= h)
            return;

        // parition the array into left right subarrays
        int pivot = partition(a, l, h);

        // recur on left and right subarrays
        quicksort(a, l, pivot - 1);
        quicksort(a, pivot + 1, h);
        ;

    }

    private static int partition(int[] a, int l, int h) {
        // choose the last element as pivot
        // all elements smaller than this end up on its left
        int pivot = a[h];

        int pIndex = l;

        for (int i = l; i < h; i++) {

            // found smaller number?
            if (a[i] < pivot) {
                // move it to left subarray and increment boundary of left subarray
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }

        // put the pivot element at its appropriate place
        int temp = a[end];
        a[end] = a[pIndex];
        a[pIndex] = temp;

        // return the index of pivot
        return pIndex;

    }

}
