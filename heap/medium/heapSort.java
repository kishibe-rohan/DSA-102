//Given an array of elements,perform heap sort on it (in-place)
//Steps : 1) Heapify the array (max heap)  2) Extract largest element and reduce heap sie by 1 till heap size becomes 1

public class heapSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;

        // build max heap from the array
        // start from last non-leaf index
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // extract largest element one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify the remaining array
            heapify(arr, i, 0);
        }

    }

    static void heapify(int arr[], int n, int i) {
        int largest = i; // consider root element as largest

        // get its left and rigth children
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // swap root with the larger of its children to maintain max heap property
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // heapify the affected subarray
            heapify(arr, n, largest);
        }
    }
}
