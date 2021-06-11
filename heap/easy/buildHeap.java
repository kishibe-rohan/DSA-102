//Given an array of elements,heapify it (max heap)

public class buildHeap {
    public static void main(String[] args) {

        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        int n = arr.length;

        makeHeap(arr, n);
    }

    static void makeHeap(int[] arr, int n) {
        int lastNonLeafIdx = (n / 2) - 1;

        // reverse level order traversal
        for (int i = lastNonLeafIdx; i >= 0; i--)
            heapify(arr, n, i);
    }

    static void heapify(int[] arr, int n, int rooIndex) {
        int largest = rootIndex; // consider root element as largest

        // get its left and right children
        int left = 2 * rooIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        // swap root with the larger of its children
        // if root is larger than both its children,then its already in max heap form

        if (largest != rooIndex) {
            int temp = arr[largest];
            arr[largest] = arr[rooIndex];
            arr[rootIndex] = temp;

            // recurse for the modified subtree
            heapify(arr, n, largest);
        }
    }
}